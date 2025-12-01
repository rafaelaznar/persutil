package net.ausiasmarch.persutil.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.persutil.entity.AlcanyizEntity;
import net.ausiasmarch.persutil.repository.AlcanyizRepository;

@Service
public class AlcanyizService {

    @Autowired
    AlcanyizRepository oAlcanyizRepository;

    public AlcanyizEntity get(Long id) {
        return oAlcanyizRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    public Long create(AlcanyizEntity alcanyizEntity) {
        alcanyizEntity.setCreate_date(LocalDateTime.now());
        alcanyizEntity.setModify_date(null);
        oAlcanyizRepository.save(alcanyizEntity);
        return alcanyizEntity.getId();
    }

        public Long update(AlcanyizEntity alcanyizEntity) {
        AlcanyizEntity existingQuestionsAC = oAlcanyizRepository.findById(alcanyizEntity.getId())
                .orElseThrow(() -> new RuntimeException("Question not found"));
        existingQuestionsAC.setQuestion(alcanyizEntity.getQuestion());
        existingQuestionsAC.setAnswer1(alcanyizEntity.getAnswer1());
        existingQuestionsAC.setAnswer2(alcanyizEntity.getAnswer2());
        existingQuestionsAC.setAnswer3(alcanyizEntity.getAnswer3());
        existingQuestionsAC.setAnswer4(alcanyizEntity.getAnswer4());
        existingQuestionsAC.setCorrect(alcanyizEntity.getCorrect());
        existingQuestionsAC.setModify_date(LocalDateTime.now());
        oAlcanyizRepository.save(existingQuestionsAC);
        return existingQuestionsAC.getId();
    }

    public Long delete(Long id) {
        oAlcanyizRepository.deleteById(id);
        return id;
    }

    public Page<AlcanyizEntity> getPage(Pageable oPageable) {
        return oAlcanyizRepository.findAll(oPageable);
    }

    public Long count() {
        return oAlcanyizRepository.count();
    }

    public Long rellenaQuestions(Long numQuestions) {
        for (int i = 0; i < numQuestions; i++) {
            int correctAnswer = GenerarNumeroAleatorio();
            AlcanyizEntity oAlcanyizEntity = new AlcanyizEntity();
            oAlcanyizEntity.setQuestion("Pregunta de prueba " + (i + 1));
            if (correctAnswer == 1) {
                oAlcanyizEntity.setAnswer1("Respuesta correcta");
            } else {
                oAlcanyizEntity.setAnswer1("Respuesta incorrecta");
            }
            if (correctAnswer == 2) {
                oAlcanyizEntity.setAnswer2("Respuesta correcta");
            } else {
                oAlcanyizEntity.setAnswer2("Respuesta incorrecta");
            }
            if (correctAnswer == 3) {
                oAlcanyizEntity.setAnswer3("Respuesta correcta");
            } else {
                oAlcanyizEntity.setAnswer3("Respuesta incorrecta");
            }
            if (correctAnswer == 4) {
                oAlcanyizEntity.setAnswer4("Respuesta correcta");
            } else {
                oAlcanyizEntity.setAnswer4("Respuesta incorrecta");
            }
            oAlcanyizEntity.setCorrect(correctAnswer);
            // establecer fecha de creación y modificación
            oAlcanyizEntity.setCreate_date(LocalDateTime.now());
            oAlcanyizEntity.setModify_date(null);
            // guardar entity en base de datos
            oAlcanyizRepository.save(oAlcanyizEntity);
        }
        return oAlcanyizRepository.count();
    }

    public int GenerarNumeroAleatorio() {
        return (int) (Math.random() * (4 - 1 + 1)) + 1;
    }   
}
