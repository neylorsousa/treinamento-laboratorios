import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BoasPraticasTeste {

	List<String> dados = new ArrayList<>();

	@Test
	public void testeDependenciaEntreTeste1() {
		dados.add("dado 1");
		dados.add("dado 2");
		Assert.assertThat(dados.size(), CoreMatchers.equalTo(2));
	}

	@Test
	public void testeDependenciaEntreTeste2() {
		dados.add("dado 3");
		Assert.assertThat(dados.size(), CoreMatchers.equalTo(3));
	}

	@Test
	//A maior parte das vezes, multiplas assercoes indica a segregação e mais de um teste
	public void testeEvitarMultiplasAssercoes() {
		dados.clear();
		dados.add("dado 1");
		dados.add("dado 2");
		Assert.assertThat(dados.size(), CoreMatchers.equalTo(2));
		dados.add("dado 3");
		Assert.assertThat(dados.size(), CoreMatchers.equalTo(3));
	}
  
	@Test
	//Irá funcionar apenas durante alguns dias
	public void testeAtemporal(){
		LocalDate hoje = LocalDate.now();
		LocalDate diaUtil = LocalDateUtil.adicionarDiaUtil(hoje, 5);
		Assert.assertThat(diaUtil, CoreMatchers.equalTo(LocalDate.of(2016,11,16)));
	}
  
}
