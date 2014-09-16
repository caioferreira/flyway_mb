package br.com.dclick.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.dclick.dto.Pessoa;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.GET)
	public String getPessoas(Model model) {
		String sql = "SELECT * FROM PESSOA";

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(Long.valueOf(row.get("id").toString()));
			pessoa.setNome((String) row.get("nome"));
			pessoa.setIdade(Long.valueOf(row.get("idade").toString()));
			pessoas.add(pessoa);
		}
		model.addAttribute("pessoas", pessoas);
		model.addAttribute("pessoa", new Pessoa());
		return "pessoa";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String inserirPessoa(@ModelAttribute Pessoa pessoa, Model model) {
		jdbcTemplate.execute("insert into pessoa(nome,idade) values ("+ "'" + pessoa.getNome() + "'," +pessoa.getIdade() + ")");
		return "redirect:pessoa";
	}
}
