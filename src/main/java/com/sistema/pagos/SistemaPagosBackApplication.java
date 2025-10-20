package com.sistema.pagos;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sistema.pagos.entities.Estudiante;
import com.sistema.pagos.entities.Pago;
import com.sistema.pagos.enums.PagoStatus;
import com.sistema.pagos.enums.TypePago;
import com.sistema.pagos.repository.EstudianteRepository;
import com.sistema.pagos.repository.PagoRepository;

@SpringBootApplication
public class SistemaPagosBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPagosBackApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(EstudianteRepository estudianteRepository, PagoRepository pagoRepository) {
		return args -> {
			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Andres")
					.apellido("Vanega")
					.codigo("1234")
					.programaId("LTA1")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Andres")
					.apellido("Ramirez")
					.codigo("12354")
					.programaId("LTA1")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Nicolas")
					.apellido("Ramirez")
					.codigo("22445566")
					.programaId("LTA1")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Raul")
					.apellido("Ramirez")
					.codigo("12349030")
					.programaId("LTA2")
					.build());

			TypePago tiposPago[] = TypePago.values();
			Random random = new Random();

			estudianteRepository.findAll().forEach(estudiante -> {
				for (int i = 0; i < 10; i++) {
					int index = random.nextInt(tiposPago.length);
					Pago pago = Pago.builder()
							.cantidad(1000 + (int) (Math.random() * 20000))
							.type(tiposPago[index])
							.status(PagoStatus.CREADO)
							.fecha(LocalDate.now())
							.estudiante(estudiante)
							.build();
					pagoRepository.save(pago);
				}
			});
		};
	}
}