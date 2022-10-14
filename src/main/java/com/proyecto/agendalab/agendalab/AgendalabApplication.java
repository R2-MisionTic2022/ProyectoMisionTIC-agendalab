package com.proyecto.agendalab.agendalab;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.proyecto.agendalab.agendalab.model.entity.Examen;
import com.proyecto.agendalab.agendalab.model.entity.Seccion;
import com.proyecto.agendalab.agendalab.model.entity.Usuario;
import com.proyecto.agendalab.agendalab.model.repository.ExamenRepository;
import com.proyecto.agendalab.agendalab.model.repository.SeccionRepository;
import com.proyecto.agendalab.agendalab.model.repository.UsuarioRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@SpringBootApplication
public class AgendalabApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendalabApplication.class, args);
	}

	@Component
	@Data
	@AllArgsConstructor
	public static class DataLoader implements CommandLineRunner {

		private final SeccionRepository seccionRepository;
		private final ExamenRepository examenRepository;
		private final UsuarioRepository usuarioRepository;

		@Override
		public void run(String... args) throws Exception {
			//cargarUsuarios();
			//cargarSecciones();
			//cargarExamenes();
		}

		private void cargarUsuarios() {
			
			usuarioRepository.deleteAll();

			usuarioRepository.saveAll(Arrays.asList(
					new Usuario("admin", (long) 1085963452, "12345", "Andres", "Guevara",
							"andresguevara_1981@hotmail.com", "Carrera 2B # 59D 51", "3206984563", true, true),
					new Usuario("admin2", (long) 1085310569, "123456", "Cristhian", "Medina",
							"cristhian.medina.o@gmail.com", "Manzana 15 casa 9", "3206764849", true, true)));
		}

		private void cargarSecciones() {

			seccionRepository.deleteAll();

			seccionRepository.saveAll(Arrays.asList(
					new Seccion("Inmunología"),
					new Seccion("Microbiología"),
					new Seccion("Química"),
					new Seccion("Hematología")));
		}

		private void cargarExamenes() {

			examenRepository.deleteAll();

			var inmuno = seccionRepository.findByNombre("Inmunología").get();
			var micro = seccionRepository.findByNombre("Microbiología").get();
			var quim = seccionRepository.findByNombre("Química").get();
			var hema = seccionRepository.findByNombre("Hematología").get();

			examenRepository.saveAll(Arrays.asList(
				// Examenes de Microbiología
					new Examen((long) 901001, "ANTIBIOGRAMA (DISCO)", 25000.00, micro,
							"El antibiograma es la prueba microbiológica que se realiza para determinar la susceptibilidad (sensibilidad o resistencia) de una bacteria a un grupo de antibiótico"),
					new Examen((long) 901107, "GRAM DE ORINA", 65000.00, micro,
							"Prueba que detecta bacterias en el lugar donde se sospecha una infección, como la garganta, los pulmones, los genitales o las lesiones en la piel"),

				// Examenes de Hematología
					new Examen((long) 902213, "HEMOGLOBINA", 25000.00, hema,
							"El análisis de hemoglobina mide los niveles de hemoglobina en la sangre"),
					new Examen((long) 911015, "HEMOCLASIFICACION", 25000.00, hema,
							"La hemoclasificación determina el tipo de antígenos en la sangre para su clasificación"),

				// Examenes de Inmunología
					new Examen((long) 906249, "VIH 1 Y 2", 75000.00, inmuno,
							"El VIH-1 es el causante de la pandemia mundial de sida mientras que el VIH-2, aunque también puede producir sida, se considera menos patogénico y menos transmisible"),
					new Examen((long) 906305, "DENGUE DUO NS1", 45000.00, inmuno,
							"La prueba de NS1 detecta la proteína no estructural NS1 del virus del dengue. Esta proteína se secreta a la sangre durante la infección por dengue."),
     			
				// Examenes de Química
					new Examen((long) 903895, "CREATININA", 25000.00, quim,
							"Es una prueba que mide los niveles de creatinina en la sangre o en la orina. La creatinina es un producto de desecho generado por los músculos como parte de la actividad diaria"),
					new Examen((long) 903841, "GLUCOSA", 25000.00, quim,
							"La prueba de glucosa en la sangre mide los niveles de glucosa en la sangre. La glucosa es un tipo de azúcar")

			));
		}

	}

}
