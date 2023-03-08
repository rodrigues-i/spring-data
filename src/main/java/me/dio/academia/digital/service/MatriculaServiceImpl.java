package me.dio.academia.digital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private MatriculaRepository matriculaRepository;

	@Override
	public Matricula create(MatriculaForm form) {
		Matricula matricula = new Matricula();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		matricula.setAluno(aluno);
		return matriculaRepository.save(matricula);

	}

	@Override
	public Matricula get(Long id) {
		return matriculaRepository.findById(id).get();
	}

	@Override
	public List<Matricula> getAll(String bairro) {
		if (bairro == null) {
			return matriculaRepository.findAll();
		}

		return matriculaRepository.findByAlunoBairro(bairro);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
