package EjercicioPractico1;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                // Permitir acceso público a recursos estáticos
                .requestMatchers("/", "/index", "/errores/**", "/js/**", "/webjars/**", "/css/**", "/images/**").permitAll()
                // Permitir acceso a ciertas rutas según el rol
                .requestMatchers("/producto/listado", "/producto/formulario").hasRole("VENDEDOR")
                .anyRequest().authenticated()
            )
            // Configuración de inicio de sesión
            .formLogin((form) -> form
                .loginPage("/login").permitAll()
            )
            // Configuración de cierre de sesión
            .logout((logout) -> logout.permitAll());
        return http.build();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
