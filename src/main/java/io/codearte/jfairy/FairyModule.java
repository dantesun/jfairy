package io.codearte.jfairy;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import io.codearte.jfairy.producer.company.CompanyFactory;
import io.codearte.jfairy.producer.payment.IBANFactory;
import io.codearte.jfairy.producer.person.PersonFactory;
import io.codearte.jfairy.producer.person.locale.pl.PeselFactory;

import java.util.Random;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-11-15
 */
public abstract class FairyModule extends AbstractModule {

	private final Random random;

	public FairyModule(Random random) {
		this.random = random;
	}

	@Override
	protected void configure() {
		bind(Random.class).toInstance(random);

		install(new FactoryModuleBuilder().build(PersonFactory.class));
		install(new FactoryModuleBuilder().build(FairyFactory.class));
		install(new FactoryModuleBuilder().build(CompanyFactory.class));
		install(new FactoryModuleBuilder().build(PeselFactory.class));
		install(new FactoryModuleBuilder().build(IBANFactory.class));
	}
}
