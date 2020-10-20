package com.util;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.ajp.AbstractAjpProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class AppConfig {

	@Value("${tomcat.ajp.port}")
	int ajpPort;

	@Value("${tomcat.ajp.remoteauthentication}")
	String remoteAuthentication;

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> servletContainer() {
		return server ->
		Optional.ofNullable(server)
		.ifPresent(s -> s.addAdditionalTomcatConnectors(redirectConnector()));
	}

	private Connector redirectConnector() {
		Connector ajpConnector = new Connector("AJP/1.3");
		ajpConnector.setPort(ajpPort);
		ajpConnector.setSecure(false);
		ajpConnector.setAllowTrace(false);
		ajpConnector.setScheme("https");
		((AbstractAjpProtocol) ajpConnector.getProtocolHandler()).setSecretRequired(false);

		return ajpConnector;
	}

}