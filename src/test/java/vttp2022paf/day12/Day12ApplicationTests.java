package vttp2022paf.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vttp2022paf.day12.models.Gif;
import vttp2022paf.day12.service.SearchService;

@SpringBootTest
class Day12ApplicationTests {

	@Autowired
	private SearchService srcserv;

	@Test
	void shouldload10images() {
		List<Gif> gifs = srcserv.search("dog",10,"g");
		assertEquals(10,gifs.size());

	}

}
