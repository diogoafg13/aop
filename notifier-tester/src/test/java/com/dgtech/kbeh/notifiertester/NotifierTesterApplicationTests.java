package com.dgtech.kbeh.notifiertester;

import com.dgtech.kbeh.notifier.NotifyKBEH;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NotifierTesterApplicationTests {

	@Test
	@NotifyKBEH(type="test")
	void contextLoads() {
	}

}
