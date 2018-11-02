package FeignToIRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
//Ribbon自定义访问策略不能放在@ComponentScan下，放在下面会导致全部都是这个策略，达不到这对某个而策划的访问策略
@Configuration
public class FeignToIRule {

	@Bean
	public IRule myIRule() {
		return new RandomRule();
	}
}
