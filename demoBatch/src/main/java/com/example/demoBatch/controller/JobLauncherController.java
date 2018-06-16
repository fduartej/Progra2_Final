package com.example.demoBatch.controller;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoBatch.model.Person;
import com.example.demoBatch.service.serviceImpl.MailServiceImpl;
import com.example.demoBatch.service.serviceImpl.PersonServiceImpl;
import com.example.demoBatch.service.serviceImpl.VehiculoServiceImpl;
import com.example.demoBatch.util.CambioActual;

@RestController
public class JobLauncherController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@Autowired
	@Qualifier("personServiceImpl")
	private PersonServiceImpl personServiceImpl;

	@Autowired
	@Qualifier("vehiculoServiceImpl")
	private VehiculoServiceImpl vehiculoServiceImpl;

	@Autowired
	@Qualifier("mailServiceImpl")
	private MailServiceImpl mailServiceImpl;

	///////////////////////////////////////////////
	CambioActual cambioActual = new CambioActual();
	double dolarEnSoles = Double.parseDouble(cambioActual.valor());
	///////////////////////////////////////////////

	@Scheduled(cron = "0 * * ? * *") // Cada minuto
	public String handle() throws Exception {

		Logger logger = LoggerFactory.getLogger(this.getClass());

		// JOB
		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			jobLauncher.run(job, jobParameters);
			logger.info("Hora Actual :: " + Calendar.getInstance().getTime());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		
		List<Person> listaP = null;

		listaP = personServiceImpl.listAll();
		for (Person person : listaP) {
			System.out.println(person);
			System.out.println("localhost:8082/lista/"+person.getId()); 
			String mensaje = (""+"<a href=\"http://localhost:8082/lista/"+person.getId()+"\">Haga Click Aqui</a>"+"");
			char flagpersona=' ';
			flagpersona = person.getFlag_correo();
			if (flagpersona=='0') {
//			Correo
			mailServiceImpl.enviarCorreo(person.getCorreo(),mensaje);
			person.setFlag_correo('1'); 
			personServiceImpl.actualizar(person);
			} else {
				System.out.println("Ya se ha enviado correo a:"+" "+person.getNombre());
			}
			System.out.println(person);
		}
		
		System.out.println("Tipo de Cambio de Soles En Dolares: " + dolarEnSoles);

		// Mensaje
		return "Job Ejecutado";
	}
}