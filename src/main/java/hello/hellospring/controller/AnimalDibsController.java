package hello.hellospring.controller;

import hello.hellospring.domain.Animal;
import hello.hellospring.service.DibsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AnimalDibsController {
    private final DibsService dibsService;

    @Autowired
    public AnimalDibsController(DibsService dibsService) {
        this.dibsService = dibsService;
    }

    @PostMapping("/animal/animalDibs")
    @ResponseBody
    public boolean dibs(DibsForm form) {
        Animal animal = new Animal();
        animal.setSexCd(form.getSexCd());
        animal.setAge(form.getAge());
        animal.setCareAddr(form.getCareAddr());
        animal.setCareNm(form.getCareNm());
        animal.setCareTel(form.getCareTel());
        animal.setKindCd(form.getKindCd());
        animal.setDesertionNo(form.getDesertionNo());
        animal.setPopfile(form.getPopfile());
        animal.setProcessState(form.getProcessState());
        animal.setSpecialMark(form.getSpecialMark());
        animal.setWeight(form.getWeight());
        animal.setName(form.getName());
        return dibsService.dibs(animal);
    }

    @PostMapping("/animal/dibsList")
    @ResponseBody
    public List<Animal> dibsList(DibsForm form) {
        List<Animal> list = dibsService.findDibs(form.getName());
//        System.out.println("list 입니다." + list);
        return list;
    }

    @PostMapping("/animal/dibsCancel")
    @ResponseBody
    public boolean cancel(DibsForm form) {
        System.out.println("desertion 숫자 입니다 !!" + form.getDesertionNo());
        Animal animal = new Animal();
        animal.setDesertionNo(form.getDesertionNo());
        return dibsService.cancelDibs(animal.getDesertionNo());
    }
}
