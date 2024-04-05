package hello.ch05.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello(Model model) {

        log.info("hello..........");

        model.addAttribute("msg", "HELLO WORLD");
    } // method hello

    @GetMapping("/ex/ex1")
    public void ex1(Model model) {

        List<String> list = Arrays.asList("AAA", "BBB", "CCC", "DDD");

        model.addAttribute("list", list);
    } // method ex1

    class SampleDTO {
        private String p1, p2, p3;
        private String getP1() {
            return p1;
        }
        private String getP2() {
            return p2;
        }
        private String getP3() {
            return p3;
        }
    } // Class SampleDTO

    @GetMapping("/ex/ex2")
    public void ex2(Model model) {

        log.info("ex/ex2.........");

        List<String> strList = IntStream.range(1, 10)
                .mapToObj(i -> "Data"+i)
                .collect(Collectors.toList());

        model.addAttribute("list", strList);

        Map<String, String> map = new HashMap<>();
        map.put("A", "AAAA");
        map.put("B", "BBBB");

        model.addAttribute("map", map);

        SampleDTO sampleDTO = new SampleDTO();
        sampleDTO.p1 = "Value -- p1";
        sampleDTO.p2 = "Value -- p2";
        sampleDTO.p3 = "Value -- p3";

        model.addAttribute("dto", sampleDTO);
    } // method ex2
}