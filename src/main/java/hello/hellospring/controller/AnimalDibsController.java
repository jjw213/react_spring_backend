package hello.hellospring.controller;

import hello.hellospring.domain.Animal;
import hello.hellospring.service.AnimalService;
import hello.hellospring.service.DibsService;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnimalDibsController {
    private final DibsService dibsService;
    @Autowired
    public AnimalDibsController(DibsService dibsService) {
        this.dibsService = dibsService;
    }

    @PostMapping("/animal/animalDibs")
    @ResponseBody
    public Animal dibs(DibsForm form) {
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
//System.out.println();
        dibsService.dibs(animal);
        return animal;
    }
}