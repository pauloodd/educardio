package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.hibernate.SessionFactory;

import dados.hibernate.HibernateUtil;
import fachada.Fachada;
import model.Endereco;
import model.curso.Curso;
import model.curso.EstudoDeCaso;
import model.curso.matricula.AvaliacaoProfessor;
import model.curso.matricula.arcomaguerez.Implementacao;
import model.curso.matricula.arcomaguerez.Planejamento;
import model.curso.matricula.arcomaguerez.ResultadosEsperados;
import model.sistema.Arquivo;
import model.usuario.Administrador;
import model.usuario.Aluno;
import model.usuario.Professor;

public class MainPopulaBD {
	
	public static void execCriarArqvsCurso(){
		
		SessionFactory sf = HibernateUtil.getFabricaDeSessao();
		sf.getCurrentSession().beginTransaction();
		
		InputStream input;
		try {
			Arquivo arqv1 = new Arquivo();
			Arquivo arqv2 = new Arquivo();
			Arquivo arqv3 = new Arquivo();
			Arquivo arqv4 = new Arquivo();
			Arquivo arqv5 = new Arquivo();
			Arquivo arqv6 = new Arquivo();
			Arquivo arqv7 = new Arquivo();
			Arquivo arqv8 = new Arquivo();
			
			arqv1.setExtensao("application/pdf");
			arqv1.setNomeArqv("caderneta_saude_crianca.pdf");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Comuns aos 3 estudos de caso\\caderneta_saude_crianca.pdf");
			byte[] arraybytes = IOUtils.toByteArray(input);
			arqv1.setDadosArqv(arraybytes);
			
			arqv2.setExtensao("application/pdf");
			arqv2.setNomeArqv("caderneta_saude_crianca_menina_7ed.pdf");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Comuns aos 3 estudos de caso\\caderneta_saude_crianca_menina_7ed.pdf");
			arraybytes = IOUtils.toByteArray(input);
			arqv2.setDadosArqv(arraybytes);
			
			arqv3.setExtensao("application/pdf");
			arqv3.setNomeArqv("caderneta_saude_crianca_menino_7ed.pdf");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Comuns aos 3 estudos de caso\\caderneta_saude_crianca_menino_7ed.pdf");
			arraybytes = IOUtils.toByteArray(input);
			arqv3.setDadosArqv(arraybytes);
			
			arqv4.setExtensao("application/pdf");
			arqv4.setNomeArqv("caderno_de_atencao_basica_crescimento_e_desenvolvimento_infantil.pdf");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Comuns aos 3 estudos de caso\\caderno_de_atencao_basica_crescimento_e_desenvolvimento_infantil.pdf");
			arraybytes = IOUtils.toByteArray(input);
			arqv4.setDadosArqv(arraybytes);
			
			arqv5.setExtensao("application/pdf");
			arqv5.setNomeArqv("curvas_oms_2006_2007.pdf");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Comuns aos 3 estudos de caso\\curvas_oms_2006_2007.pdf");
			arraybytes = IOUtils.toByteArray(input);
			arqv5.setDadosArqv(arraybytes);
			
			arqv6.setExtensao("application/pdf");
			arqv6.setNomeArqv("estatuto_crianca_adolescente_10ed.pdf");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Comuns aos 3 estudos de caso\\estatuto_crianca_adolescente_10ed.pdf");
			arraybytes = IOUtils.toByteArray(input);
			arqv6.setDadosArqv(arraybytes);
			
			arqv7.setExtensao("application/pdf");
			arqv7.setNomeArqv("Organizacao_dos_cuidados_e_a_parceria_com_os_pais_em_pediatria_2012.pdf");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Comuns aos 3 estudos de caso\\Organizacao_dos_cuidados_e_a_parceria_com_os_pais_em_pediatria_2012.pdf");
			arraybytes = IOUtils.toByteArray(input);
			arqv7.setDadosArqv(arraybytes);
			
			arqv8.setExtensao("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
			arqv8.setNomeArqv("Links_para_videos.docx");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Comuns aos 3 estudos de caso\\Links_para_videos.docx");
			arraybytes = IOUtils.toByteArray(input);
			arqv8.setDadosArqv(arraybytes);
			
			List<Arquivo> listaArqv = new ArrayList<Arquivo>();
			listaArqv.add(arqv1);
			listaArqv.add(arqv2);
			listaArqv.add(arqv3);
			listaArqv.add(arqv4);
			listaArqv.add(arqv5);
			listaArqv.add(arqv6);
			listaArqv.add(arqv7);
			listaArqv.add(arqv8);
			Fachada.getInstancia().inserirArquivosCurso(listaArqv);
			
			sf.getCurrentSession().getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public static void execMainPopulaBD(){
		

		SessionFactory sf = HibernateUtil.getFabricaDeSessao();
		sf.getCurrentSession().beginTransaction();
		Endereco end = new Endereco("Rua Arcoverde","180","Janga","53439110","Paulista","PE","Ponto de Referencia");
		Endereco end2 = new Endereco("Rua Arcoverde","180","Janga","53439110","Paulista","PE","Ponto de Referencia");
		Endereco end3= new Endereco("Rua Arcoverde","180","Janga","53439110","Paulista","PE","Ponto de Referencia");
		Endereco end4= new Endereco("Rua Arcoverde","180","Janga","53439110","Paulista","PE","Ponto de Referencia");
		
		Aluno alunoAsd = new Aluno("Paulo Diniz","01234567891",end,"asd","asd","podd@cin.ufpe.br", "Masculino", 0, "UFPE");
		Fachada.getInstancia().criarUsuarioAluno(alunoAsd);
		
		Aluno aluno = new Aluno("Paulo Diniz","01234567891",end2,"aluno","aluno","tesra@gmail.com", "Masculino", 0, "UFPE");
		Fachada.getInstancia().criarUsuarioAluno(aluno);
		
		Professor professor = new Professor("Rosalie Belian","01234567891",end3,"professor","professor","rosalie.belian@gmail.com", "Feminino", 0, "UFPE");
		Fachada.getInstancia().criarUsuarioProfessor(professor);
		
		Administrador admin = new Administrador("Administrador Sistema","01234567891",end4,"admin","admin","tffesra@gmail.com", "Masculino", 0);
		Fachada.getInstancia().criarUsuarioAdministrador(admin);
		
		Curso curso1 = new Curso(0, "O Processo de Enfermagem Aplicado à Criança de 0 a 2 anos", "Este curso tem por objetivo desenvolver no aluno competências e habilidades relacionadas ao exercício do Processo de Enfermagem no atendimento à criança de 0 a 2 anos. O curso está estruturado no método de ensino do Arco de Charles Maguerez (Metodologia da Problematização), sendo formado por três cenários educativos (situações-problemas) de níveis de complexidade progressivos. Durante o curso o aluno contextualizará a aprendizagem para a realidade social da criança atendida no serviço de puericultura, propondo um planejamento do cuidado à luz da Classificação Internacional de Práticas de Enfermagem em Saúde Coletiva (CIPESC).",
				"",
				new Date(2014,4,7), new Date(2014,4,29), Curso.ANDAMENTO, professor, null);
		
		
		curso1 = Fachada.getInstancia().inserirCurso(curso1);
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(curso1);
		
		Fachada.getInstancia().matricularAlunoCursos(alunoAsd, cursos);
		
		sf.getCurrentSession().getTransaction().commit();
		
	}
	
	public static void execPopulaMateriais(){
		

		SessionFactory sf = HibernateUtil.getFabricaDeSessao();
		sf.getCurrentSession().beginTransaction();
		
//		Material mat1 = new Material("Mesa e cadeira para o profissional",Material.GERAL);
//		Material mat2 = new Material("Porta retrato",Material.GERAL);
//		Material mat3 = new Material("Mesa clínica",Material.GERAL);
//		Material mat4 = new Material("Armário para guardar os prontuários e receituários",Material.GERAL);
//		Material mat5 = new Material("Computador e impressora",Material.GERAL);
//		Material mat6 = new Material("Fogão",Material.GERAL);
//		Material mat7 = new Material("Abajur",Material.GERAL);
//		Material mat8 = new Material("Geladeira",Material.GERAL);
//		Material mat9 = new Material("Televisão",Material.GERAL);
//		Material mat10 = new Material("Aparelho de DVD/BLU-RAY",Material.GERAL);
//		Material mat11 = new Material("Suporte para Álcool gel/sabão líquido",Material.GERAL);
//		Material mat12 = new Material("Lixeira para lixo comum",Material.GERAL);
//		Material mat13 = new Material("Suporte para papel toalha",Material.GERAL);
//		Material mat14 = new Material("Lixeira para lixo contaminado",Material.GERAL);
//		
//		
//		Fachada.getInstancia().cadastrarMaterial(mat1);
//		Fachada.getInstancia().cadastrarMaterial(mat2);
//		Fachada.getInstancia().cadastrarMaterial(mat3);
//		Fachada.getInstancia().cadastrarMaterial(mat4);
//		Fachada.getInstancia().cadastrarMaterial(mat5);
//		Fachada.getInstancia().cadastrarMaterial(mat6);
//		Fachada.getInstancia().cadastrarMaterial(mat7);
//		Fachada.getInstancia().cadastrarMaterial(mat8);
//		Fachada.getInstancia().cadastrarMaterial(mat9);
//		Fachada.getInstancia().cadastrarMaterial(mat10);
//		Fachada.getInstancia().cadastrarMaterial(mat11);
//		Fachada.getInstancia().cadastrarMaterial(mat12);
//		Fachada.getInstancia().cadastrarMaterial(mat13);
//		Fachada.getInstancia().cadastrarMaterial(mat14);

		
//		Material mate1 = new Material("Papel Toalha",Material.USO_CORRENTE);
//		Material mate2 = new Material("Álcool 70%",Material.USO_CORRENTE);
//		Material mate3 = new Material("Algodão",Material.USO_CORRENTE);
//		Material mate4 = new Material("Papel ofício",Material.USO_CORRENTE);
//		Material mate5 = new Material("Caneta",Material.USO_CORRENTE);
//		Material mate6 = new Material("Lupa",Material.USO_CORRENTE);
//		
//		Fachada.getInstancia().cadastrarMaterial(mate1);
//		Fachada.getInstancia().cadastrarMaterial(mate2);
//		Fachada.getInstancia().cadastrarMaterial(mate3);
//		Fachada.getInstancia().cadastrarMaterial(mate4);
//		Fachada.getInstancia().cadastrarMaterial(mate5);
//		Fachada.getInstancia().cadastrarMaterial(mate6);
//		
		
//		Material mater1 = new Material("Balança pediátrica",Material.USO_CLINICO);
//		Material mater2 = new Material("Régua antropométrica",Material.USO_CLINICO);
//		Material mater3 = new Material("Estetoscópio com duas peças torácicas (diafragma e campânula)",Material.USO_CLINICO);
//		Material mater4 = new Material("Esfigmomanômetro",Material.USO_CLINICO);
//		Material mater5 = new Material("Monitor cardíaco",Material.USO_CLINICO);
//		Material mater6 = new Material("Termômetro",Material.USO_CLINICO);
//		Material mater7 = new Material("Eletrocardiógrafo",Material.USO_CLINICO);
//		Material mater8 = new Material("Glicosímetro",Material.USO_CLINICO);
//		Material mater9 = new Material("Fita métrica",Material.USO_CLINICO);
//		Material mater10 = new Material("Lanterna",Material.USO_CLINICO);
//		Material mater11 = new Material("Otoscópio",Material.USO_CLINICO);
//		Material mater12 = new Material("Ventilador mecânico",Material.USO_CLINICO);
//		
//		
//		Fachada.getInstancia().cadastrarMaterial(mater1);
//		Fachada.getInstancia().cadastrarMaterial(mater2);
//		Fachada.getInstancia().cadastrarMaterial(mater3);
//		Fachada.getInstancia().cadastrarMaterial(mater4);
//		Fachada.getInstancia().cadastrarMaterial(mater5);
//		Fachada.getInstancia().cadastrarMaterial(mater6);
//		Fachada.getInstancia().cadastrarMaterial(mater7);
//		Fachada.getInstancia().cadastrarMaterial(mater8);
//		Fachada.getInstancia().cadastrarMaterial(mater9);
//		Fachada.getInstancia().cadastrarMaterial(mater10);
//		Fachada.getInstancia().cadastrarMaterial(mater11);
//		Fachada.getInstancia().cadastrarMaterial(mater12);
		
		sf.getCurrentSession().getTransaction().commit();
	
	}
	
	public static void execCadastrarEstudosDeCasos(){
		SessionFactory sf = HibernateUtil.getFabricaDeSessao();
		sf.getCurrentSession().beginTransaction();
		try {
			Curso curso = new Curso(1);
			InputStream input;
			
			List<Arquivo> imagensEc1 = new ArrayList<Arquivo>();
			List<Arquivo> imagensEc2 = new ArrayList<Arquivo>();
			List<Arquivo> imagensEc3 = new ArrayList<Arquivo>();
			List<Arquivo> imgsAux1 = new ArrayList<Arquivo>();
			List<Arquivo> imgsAux2 = new ArrayList<Arquivo>();
			List<Arquivo> imgsAux3 = new ArrayList<Arquivo>();
			
			Arquivo arqv = new Arquivo();
			arqv.setExtensao("image/jpeg");
			arqv.setNomeArqv("estudoDeCasoI.jpg");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Imagem do caso\\estudoDeCasoI.jpg");
			byte[] arraybytes = IOUtils.toByteArray(input);
			arqv.setDadosArqv(arraybytes);
			imagensEc1.add(arqv);
			
			Arquivo arqv3 = new Arquivo();
			arqv3.setExtensao("image/jpeg");
			arqv3.setNomeArqv("estudoDeCasoII.jpg");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Imagem do caso\\estudoDeCasoII.jpg");
			arraybytes = IOUtils.toByteArray(input);
			arqv3.setDadosArqv(arraybytes);
			imagensEc2.add(arqv3);
			
			Arquivo arqv4 = new Arquivo();
			arqv4.setExtensao("image/jpeg");
			arqv4.setNomeArqv("estudoDeCasoIII.jpg");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Imagem do caso\\estudoDeCasoIII.jpg");
			arraybytes = IOUtils.toByteArray(input);
			arqv4.setDadosArqv(arraybytes);
			imagensEc3.add(arqv4);
			
			Arquivo arqvEc1Aux1 = new Arquivo();
			arqvEc1Aux1.setExtensao("image/png");
			arqvEc1Aux1.setNomeArqv("photo01.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso I\\Captura de tela 2014-01-15 12.45.58.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc1Aux1.setDadosArqv(arraybytes);
			imgsAux1.add(arqvEc1Aux1);
			Arquivo arqvEc1Aux2 = new Arquivo();
			arqvEc1Aux2.setExtensao("image/png");
			arqvEc1Aux2.setNomeArqv("photo02.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso I\\Captura de tela 2014-01-15 12.46.03.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc1Aux2.setDadosArqv(arraybytes);
			imgsAux1.add(arqvEc1Aux2);
			Arquivo arqvEc1Aux3 = new Arquivo();
			arqvEc1Aux3.setExtensao("image/png");
			arqvEc1Aux3.setNomeArqv("photo03.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso I\\Captura de tela 2014-01-15 12.46.10.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc1Aux3.setDadosArqv(arraybytes);
			imgsAux1.add(arqvEc1Aux3);
			Arquivo arqvEc1Aux4 = new Arquivo();
			arqvEc1Aux4.setExtensao("image/png");
			arqvEc1Aux4.setNomeArqv("photo04.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso I\\Captura de tela 2014-01-15 12.46.17.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc1Aux4.setDadosArqv(arraybytes);
			imgsAux1.add(arqvEc1Aux4);
			Arquivo arqvEc1Aux5 = new Arquivo();
			arqvEc1Aux5.setExtensao("image/png");
			arqvEc1Aux5.setNomeArqv("photo05.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso I\\Captura de tela 2014-01-15 12.46.24.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc1Aux5.setDadosArqv(arraybytes);
			imgsAux1.add(arqvEc1Aux5);
			Arquivo arqvEc1Aux6 = new Arquivo();
			arqvEc1Aux6.setExtensao("image/png");
			arqvEc1Aux6.setNomeArqv("photo06.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso I\\Captura de tela 2014-01-15 12.46.30.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc1Aux6.setDadosArqv(arraybytes);
			imgsAux1.add(arqvEc1Aux6);
			Arquivo arqvEc1Aux7 = new Arquivo();
			arqvEc1Aux7.setExtensao("image/png");
			arqvEc1Aux7.setNomeArqv("photo07.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso I\\Captura de tela 2014-01-15 12.46.41.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc1Aux7.setDadosArqv(arraybytes);
			imgsAux1.add(arqvEc1Aux7);
			Arquivo arqvEc1Aux8 = new Arquivo();
			arqvEc1Aux8.setExtensao("image/png");
			arqvEc1Aux8.setNomeArqv("photo08.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso I\\Captura de tela 2014-01-15 12.46.47.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc1Aux8.setDadosArqv(arraybytes);
			imgsAux1.add(arqvEc1Aux8);
			Arquivo arqvEc1Aux9 = new Arquivo();
			arqvEc1Aux9.setExtensao("image/png");
			arqvEc1Aux9.setNomeArqv("photo09.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso I\\Captura de tela 2014-01-15 12.46.52.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc1Aux9.setDadosArqv(arraybytes);
			imgsAux1.add(arqvEc1Aux9);
			
			Arquivo arqvEc2Aux1 = new Arquivo();
			arqvEc2Aux1.setExtensao("image/png");
			arqvEc2Aux1.setNomeArqv("photo01.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso II\\Captura de tela 2014-01-14 11.48.21.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc2Aux1.setDadosArqv(arraybytes);
			imgsAux2.add(arqvEc2Aux1);
			Arquivo arqvEc2Aux2 = new Arquivo();
			arqvEc2Aux2.setExtensao("image/png");
			arqvEc2Aux2.setNomeArqv("photo02.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso II\\Captura de tela 2014-01-14 11.48.48.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc2Aux2.setDadosArqv(arraybytes);
			imgsAux2.add(arqvEc2Aux2);
			Arquivo arqvEc2Aux3 = new Arquivo();
			arqvEc2Aux3.setExtensao("image/png");
			arqvEc2Aux3.setNomeArqv("photo03.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso II\\Captura de tela 2014-01-14 11.50.17.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc2Aux3.setDadosArqv(arraybytes);
			imgsAux2.add(arqvEc2Aux3);
			Arquivo arqvEc2Aux4 = new Arquivo();
			arqvEc2Aux4.setExtensao("image/png");
			arqvEc2Aux4.setNomeArqv("photo04.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso II\\Captura de tela 2014-01-14 11.50.43.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc2Aux4.setDadosArqv(arraybytes);
			imgsAux2.add(arqvEc2Aux4);
			Arquivo arqvEc2Aux5 = new Arquivo();
			arqvEc2Aux5.setExtensao("image/png");
			arqvEc2Aux5.setNomeArqv("photo05.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso II\\Captura de tela 2014-01-14 11.50.55.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc2Aux5.setDadosArqv(arraybytes);
			imgsAux2.add(arqvEc2Aux5);
			Arquivo arqvEc2Aux6 = new Arquivo();
			arqvEc2Aux6.setExtensao("image/png");
			arqvEc2Aux6.setNomeArqv("photo06.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso II\\Captura de tela 2014-01-14 11.52.09.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc2Aux6.setDadosArqv(arraybytes);
			imgsAux2.add(arqvEc2Aux6);
			
			Arquivo arqvEc3Aux1 = new Arquivo();
			arqvEc3Aux1.setExtensao("image/png");
			arqvEc3Aux1.setNomeArqv("photo01.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso III\\Captura de tela 2014-01-15 12.37.23.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc3Aux1.setDadosArqv(arraybytes);
			imgsAux3.add(arqvEc3Aux1);
			Arquivo arqvEc3Aux2 = new Arquivo();
			arqvEc3Aux2.setExtensao("image/png");
			arqvEc3Aux2.setNomeArqv("photo02.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso III\\Captura de tela 2014-01-15 12.37.41.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc3Aux2.setDadosArqv(arraybytes);
			imgsAux3.add(arqvEc3Aux2);
			Arquivo arqvEc3Aux3 = new Arquivo();
			arqvEc3Aux3.setExtensao("image/png");
			arqvEc3Aux3.setNomeArqv("photo03.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso III\\Captura de tela 2014-01-15 12.37.47.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc3Aux3.setDadosArqv(arraybytes);
			imgsAux3.add(arqvEc3Aux3);
			Arquivo arqvEc3Aux4 = new Arquivo();
			arqvEc3Aux4.setExtensao("image/png");
			arqvEc3Aux4.setNomeArqv("photo04.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso III\\Captura de tela 2014-01-15 12.37.53.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc3Aux4.setDadosArqv(arraybytes);
			imgsAux3.add(arqvEc3Aux4);
			Arquivo arqvEc3Aux5 = new Arquivo();
			arqvEc3Aux5.setExtensao("image/png");
			arqvEc3Aux5.setNomeArqv("photo05.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso III\\Captura de tela 2014-01-15 12.38.00.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc3Aux5.setDadosArqv(arraybytes);
			imgsAux3.add(arqvEc3Aux5);
			Arquivo arqvEc3Aux6 = new Arquivo();
			arqvEc3Aux6.setExtensao("image/png");
			arqvEc3Aux6.setNomeArqv("photo06.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso III\\Captura de tela 2014-01-15 12.38.08.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc3Aux6.setDadosArqv(arraybytes);
			imgsAux3.add(arqvEc3Aux6);
			Arquivo arqvEc3Aux7 = new Arquivo();
			arqvEc3Aux7.setExtensao("image/png");
			arqvEc3Aux7.setNomeArqv("photo07.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso III\\Captura de tela 2014-01-15 12.38.18.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc3Aux7.setDadosArqv(arraybytes);
			imgsAux3.add(arqvEc3Aux7);
			Arquivo arqvEc3Aux8 = new Arquivo();
			arqvEc3Aux8.setExtensao("image/png");
			arqvEc3Aux8.setNomeArqv("photo08.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso III\\Captura de tela 2014-01-15 12.38.26.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc3Aux8.setDadosArqv(arraybytes);
			imgsAux3.add(arqvEc3Aux8);
			Arquivo arqvEc3Aux9 = new Arquivo();
			arqvEc3Aux9.setExtensao("image/png");
			arqvEc3Aux9.setNomeArqv("photo09.png");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso III\\Captura de tela 2014-01-15 12.38.32.png");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc3Aux9.setDadosArqv(arraybytes);
			imgsAux3.add(arqvEc3Aux9);
			Arquivo arqvEc3Aux10 = new Arquivo();
			arqvEc3Aux10.setExtensao("image/jpeg");
			arqvEc3Aux10.setNomeArqv("photo10.jpg");
			input = new FileInputStream("C:\\Users\\Paulo\\Dropbox\\Objetos de aprendizagem (1)\\Imagens auxiliares dos estudos de caso\\Imagens_estudo de caso III\\ferida_estudo III.jpg");
			arraybytes = IOUtils.toByteArray(input);
			arqvEc3Aux10.setDadosArqv(arraybytes);
			imgsAux3.add(arqvEc3Aux10);
			
			EstudoDeCaso estudo = new EstudoDeCaso(EstudoDeCaso.ANDAMENTO, "Atenção de Enfermagem à Criança Sadia", "Objetivos Gerais do Estudo de Caso", "Objetivos Específicos do Estudo de Caso",
					EstudoDeCaso.ALTO, "MARIA RODRIGUES LIMA, FEMININA, NASCIDA A TERMO COM 3.250g E APGAR NO PRIMEIRO E QUINTO MINUTOS DE 8 E 10 RESPECTIVAMENTE, É ACOMPANHADA DESDE O PRIMEIRO MÊS DE VIDA PELA ENFERMEIRA NO SERVIÇO DE PUERICULTURA. A MÃE DE MARIA SEMPRE SE MOSTROU INTERESSADA EM SEGUIR AS ORIENTAÇÕES DA ENFERMEIRA. ELA NUNCA FALTOU A UMA CONSULTA E SEU ESPOSO, SEMPRE QUANDO NÃO ESTÁ TRABALHANDO, ACOMPANHA A FAMÍLIA. AOS 4 MESES DE VIDA MARIA FOI LEVADA POR SUA MÃE PARA MAIS UMA CONSULTA DE ROTINA. A ENFERMEIRA RESPONSÁVEL PELO SERVIÇO PERGUNTOU A GENITORA SOBRE O ESTADO DE SAÚDE ATUAL DA CRIANÇA. “MINHA FILHA VAI MUITO BEM GRAÇAS A DEUS, ELA AINDA NÃO SABE O QUE É UMA GRIPE E NEM O QUE É UMA DOR DE BARRIGA...” (SIC). PREOCUPADA COM O TEMPO PARA PREENCHER AS FICHAS DA PUERICULTURA, A ENFERMEIRA INTERROMPEU A ANAMNESE E INICIOU A AVALIAÇÃO DO CRESCIMENTO INFANTIL, OBTENDO ASSIM OS SEGUINTES DADOS: PESO DE 6.950g; 41 CM DE PERÍMETRO CEFÁLICO; 65 CM DE COMPRIMENTO; ÍNDICE DE MASSA CORPORAL (IMC) DE 16,4; PERÍMETRO BRAQUIAL DE 14 CM; PREGA CUTÂNEA TRICIPITAL DE 9,8 MM E PREGA CUTÂNEA SUBESCAPULAR DE 9,2 MM. A ENFERMEIRA TAMBÉM VERIFICOU QUE MARIA APRESENTAVA OS SEGUINTES MARCOS DO DESENVOLVIMENTO: RESPONDIA ATIVAMENTE AO CONTATO SOCIAL; EMITIA E LOCALIZAVA SONS;  SUSTENTAVA A CABEÇA QUANDO EM DECÚBITO DORSAL E VENTRAL; MUDAVA DE POSIÇÃO ATIVAMENTE (ROLAVA QUANDO DEITADA EM SUPERFÍCIE PLANA); PEGAVA PEQUENOS OBJETOS, TRANSFERIA-OS DE UMA MÃO PARA A OUTRA E LEVAVA OS OBJETOS À BOCA. O CALENDÁRIO VACINAL ANALISADO PELA ENFERMEIRA DEMONSTRAVA QUE MARIA ESTAVA EM DIA COM AS VACINAS RECOMENDADAS PARA A IDADE CONFORME O PROGRAMA NACIONAL DE IMUNIZAÇÃO. ELA JÁ HAVIA RECEBIDO UMA DOSE DE BCG, HEPATITE B, A 1ª DOSE DA VACINA MENINGOCÓCICA C (CONJUGADA) E A 1ª E 2ª DOSES DAS VACINAS: PENTAVALENTE (DTP+ Hib+ HB), VACINA INATIVADA POLIOMIELITE (VIP), VACINA ORAL CONTRA O ROTAVÍRUS HUMANO (VORH) E PNEUMOCÓCICA 10 (CONJUGADA). A ENFERMEIRA APROVEITOU A OPORTUNIDADE PARA PARABENIZAR A MÃE E ORIENTÁ-LA QUANTO AO AGENDAMENTO DAS PRÓXIMAS VACINAS. AO EXAME FÍSICO MARIA MOSTROU-SE: ATIVA, AFEBRIL (36.4°C), NORMOCORADA, PELE ÍNTEGRA, FONTANELA ANTERIOR ABERTA (NORMOTENSA) E POSTERIOR FECHADA. PAVILHÃO AURICULAR INDOLOR À PRESSÃO NA REGIÃO DO TRAGUS, AUSÊNCIA DE SECREÇÃO NO CONDUTO AUDITIVO EXTERNO. SUSTENTAÇÃO DO PESCOÇO COMPATÍVEL COM A IDADE E SEM ANORMALIDADES. TÓRAX SIMÉTRICO COM EXPANSÃO BILATERAL, EUPNEICO (FR 35 RPM), PRESENÇA DE MURMÚRIOS VESICULARES EM AMBOS OS HEMITÓRAX SEM RUÍDOS ADVENTÍCIOS. NORMOCÁRDICO (FC 136 BPM), ABDÔMEM PLANO, TIMPÂNICO, CICATRIZ UMBILICAL ÍNTEGRA. GENITÁLIA TÍPICA FEMININA SEM ANORMALIDADES. ", 
					imagensEc1, imgsAux1, "", curso);
			Fachada.getInstancia().cadastrarEstudoDeCaso(estudo);
			
			EstudoDeCaso estudo2 = new EstudoDeCaso(EstudoDeCaso.ANDAMENTO, "Atenção de Enfermagem à Criança em Situação de Risco", "Objetivos Gerais do Estudo de Caso", "Objetivos Específicos do Estudo de Caso",
					EstudoDeCaso.ALTO, "PEDRO HENRIQUE DA COSTA, 2 MESES, FOI LEVADO POR SUA MÃE AO SERVIÇO DE PEURICULTURA PARA MAIS UMA CONSULTA DE ROTINA. DURANTE O ATENDIMENTO A ENFERMEIRA PERCEBEU QUE A MÃE DE PEDRO SE ENCONTRAVA INQUIETA E PREOCUPADA. AO SER QUESTIONADA, A GENITORA DISSE QUE ESTAVA ANSIOSA, POIS TEMIA CHEGAR ATRASADA AO TRABALHO: “HOJE DE MANHÃ ACORDEI JÁ APERRIADA... PROCUREI ALGUÉM QUE PUDESSE TRAZER MEU FILHO À CONSULTA PARA NÃO ME ATRASAR NO SERVIÇO, MAS NÃO TEVE JEITO...NINGUÉM PÔDE ME AJUDAR...” (SIC). A ENFERMEIRA NOTOU QUE A CRIANÇA TINHA BAIXA FIXAÇÃO OCULAR, INTERAGIA POUCO, NÃO SORRIA SOCIALMENTE QUANDO ESTIMULADA, ABRIA AS MÃOS ESPONTANEAMENTE, MOVIMENTAVA ATIVAMENTE OS MEMBROS E EMITIA SONS (BALBUCIO) COM POUCA FREQUÊNCIA. TAMBÉM VERIFICOU QUE A MESMA SE ENCONTRAVA COM 4.200g DE PESO; 55 CM DE COMPRIMENTO;  IMC DE 13,5 E 38,5 CM DE PERÍMETRO CEFÁLICO. A MÃE EXPLICOU QUE HÁ UM MÊS, ANTES DE INICIAR NO TRABALHO, AMAMENTAVA SEU FILHO DIARIAMENTE, MAS QUE AGORA NÃO TINHA MAIS TEMPO, POR ISSO OFERECIA OUTROS ALIMENTOS: “NÃO TIVE DIREITO A LICENÇA MATERNIDADE, PORQUE MEU SERVIÇO É INFORMAL, PRECISO TRABALHAR PELA MANHÃ E A TARDE PARA PODER PAGAR AS CONTAS. NÃO TENHO MARIDO, MORO SOZINHA COM MINHA TIA QUE JÁ É IDOSA E NÃO TEM MAIS PACIÊNCIA PARA CUIDAR DE CRIANÇA. NÃO POSSO DEIXAR MEU FILHO COM FOME O DIA INTEIRO, POR ISSO MINHA TIA ME AJUDA DANDO LEITE DE VACA, ÁGUA E SUCO PARA ELE. SÓ A NOITE, QUANDO CHEGO DO SERVIÇO, É QUE TENHO CONDIÇÕES DE AMAMENTAR, MESMO ASSIM SINTO QUE PEDRO NÃO SEGURA DIREITO O BICO DO MEU SEIO... SABE, DESDE QUE COMECEI A TRABALHAR SINTO FALTA DOS MOMENTOS QUE INTERAGIA COM ELE”(SIC).  IGNORANDO AS QUEIXAS DA MÃE SOBRE A DEFICIÊNCIA NA REDE DE APOIO SOCIAL E VÍNCULO COM O BÊBE, A ENFERMEIRA APENAS ORIENTOU-A QUANTO A IMPORTÂNCIA DO ALEITAMENTO MATERNO EXCLUSIVO E A POSIÇÃO CORRETA DA PEGA DA CRIANÇA AO SEIO.  TAMBÉM FOI ENSINADO COMO RETIRAR E ESTOCAR O LEITE COM SEGURANÇA PARA OFERECER NOS HORÁRIOS DE TRABALHO. A GENITORA SURPRESA, AFIRMOU QUE NÃO TINHA CONHECIMENTO DESTAS INFORMAÇÕES.  DURANTE O EXAME FÍSICO PEDRO MOSTROU-SE: INQUIETO, IRRITADO, AFEBRIL (36.5°C), NORMOCORADO, PELE ÍNTEGRA, FONTANELAS ANTERIOR E POSTERIOR ABERTAS (NORMOTENSA). PUPILAS ISOCÓRICAS, FOTORREAGENTES, ESCLERÓTICA ANICTÉRICA, PAVILHÃO AURICULAR INDOLOR À PRESSÃO NA REGIÃO DO TRAGUS, AUSÊNCIA DE SECREÇÃO NO CONDUTO AUDITIVO EXTERNO. CAVIDADE ORAL SEM ANORMALIDADES, GENGIVAS NORMOCORADAS. LINFONODOS AURICULARES, OCCIPITAIS, SUBMANDIBULARES, CERVICAIS, AXILARES E INGUINAIS IMPALPÁVEIS. TÓRAX SIMÉTRICO COM EXPANSÃO BILATERAL, EUPNEICO (FR 33 RPM), PRESENÇA DE MURMÚRIOS VESICULARES EM AMBOS OS HEMITÓRAX SEM RUÍDOS ADVENTÍCIOS. NORMOCÁRDICO (FC 138 BPM), RITMO CARDÍACO REGULAR, BULHAS NORMOFONÉTICAS EM 2 TEMPOS, BOA PERFUSÃO TISSULAR PERIFÉRICA. ABDÔMEM PLANO, TIMPÂNICO, INDOLOR À PALPAÇÃO, RUÍDOS HIDROÁREOS PRESENTES, CICATRIZ UMBILICAL ÍNTEGRA. MEMBROS SUPERIORES E INFERIORES SIMÉTRICOS COM TONO E FORÇA MUSCULARES PRESERVADOS. GENITÁLIA TÍPICA MASCULINA SEM ANORMALIDADES. ", 
					imagensEc2, imgsAux2, "", curso);
			Fachada.getInstancia().cadastrarEstudoDeCaso(estudo2);
			
			EstudoDeCaso estudo3 = new EstudoDeCaso(EstudoDeCaso.ANDAMENTO, "Atenção de Enfermagem à Criança Vítima de Violência", "Objetivos Gerais do Estudo de Caso", "Objetivos Específicos do Estudo de Caso",
					EstudoDeCaso.ALTO, "GABRIELA SOARES SANTOS, 1 ANO E 7 MESES, RESIDE COM SUA MÃE, PADRASTO E 4 IRMÃOS NA PERIFERIA DA CIDADE DO RECIFE. JOSÉ FREITAS, PADRASTO DE GABRIELA, É SERVENTE DE PEDREIRO. SUA MÃE, ANTÔNIA SOARES, ESTÁ DESEMPREGADA HÁ MAIS DE 5 MESES. DESDE QUE GABRIELA NASCEU, ANTÔNIA COMEÇOU A INGERIR BEBIDAS ALCOÓLICAS. POR DUAS VEZES FOI CONDUZIDA AO SERVIÇO DE REABILITAÇÃO PARA DEPENDENTES QUÍMICOS, MAS NUNCA CONCLUIU O TRATAMENTO. QUASE TODOS OS DIAS ANTÔNIA DEIXA OS SEUS FILHOS SOZINHOS EM CASA PARA BEBER NOS BARES DA REGIÃO. A AGENTE DE SAÚDE DA FAMÍLIA POR VÁRIAS VEZES TENTOU VISITAR A RESIDÊNCIA DE ANTÔNIA. JÁ FAZIA UM MESES QUE ELA NÃO LEVAVA GABRIELA AO SERVIÇO DE PUERICULTURA, SENDO SOLICITADA SUA BUSCA ATIVA. EM UMA DAS VISITAS, A AGENTE DE SAÚDE ENCONTROU GABRIELA SOZINHA EM CASA COM SEUS 4 IRMÃOS. A CASA ESTAVA DESORGANIZADA E EM MÁS CONDIÇÕES DE HIGIENE. A CRIANÇA TINHA FEZES RESSECADAS, INDICANDO QUE HAVIA EVACUADO HÁ ALGUMAS HORAS ATRÁS. A REGIÃO GLÚTEA ESTAVA LESIONADA POR EXPOSIÇÃO CONSTANTE DA PELE ÀS SUBSTÂNCIAS IRRITANTES DAS FEZES. HAVIA HEMATOMAS NOS BRAÇOS E NAS PERNAS E O CALENDÁRIO VACINAL DA CRIANÇA ESTAVA ATRASADO.  DURANTE A VISITA, GABRIELA SE MOSTROU INQUIETA E IRRITADA, CHORANDO MUITO. A IRMÃ MAIS VELHA DE 8 ANOS EXPLICOU QUE SUA  MÃE SAIU CEDO PARA BEBER E QUE GABRIELA ESTAVA SEM COMER HÁ MAIS DE 4 HORAS, PARA “ENGANAR A FOME” (SIC) FOI OFERECIDO A ELA REFRIGERANTE E SALGADINHOS. “MINHA MÃE SAI SEMPRE CEDO DE CASA E VOLTA NO FINAL DA TARDE BÊBADA. ÀS VEZES, ELA ESTÁ CALMA, MAS TEM VEZES QUE ELA ESTÁ IRRITADA E BATE NA GENTE QUANDO CHEGA DA RUA. NOSSA VIZINHA É QUEM CUIDA DE MIM E DOS MEUS IRMÃOS” (SIC). AO TOMAR CONHECIMENTO DO FATO, A ENFERMEIRA DA UNIDADE DE SAÚDE REUNIU A EQUIPE MULTIPROFISSIONAL PARA DISCUTIR O ASSUNTO. ALÉM DOS PROFISSIONAIS DE SAÚDE, PARTICIPARAM DA REUNIÃO OS EDUCADORES DA COMUNIDADE, OS QUAIS DEBATERAM COM A EQUIPE ESTRATÉGIAS PARA O MONITORAMENTO DA FREQUÊNCIA E RENDIMENTO ESCOLAR DAS CRIANÇAS VÍTIMAS DE MAUS-TRATOS.  A ENFERMEIRA AGENDOU VISITAS DOMICILIARES PARA ACOMPANHAMENTO DA FAMÍLIA DE ANTÔNIA PELA PSICÓLOGA E A ASSISTENTE SOCIAL. VIABILIZOU O ATENDIMENTO DE GABRIELA AO SERVIÇO DE PUERICULTURA E ENCAMINHOU ANTÔNIA AO PROGRAMA COMUNITÁRIO DE AUXÍLIO, ORIENTAÇÃO E TRATAMENTO A ALCOÓLATRAS. POR SE TRATAR DE UM CASO DE NEGLIGÊNCIA E VIOLÊNCIA FÍSICA CONTRA A CRIANÇA, O CONSELHO TUTELAR FOI NOTIFICADO. EM UMA DAS CONSULTAS DE GABRIELA AO SERVIÇO DE PUERICULTURA A ENFERMEIRA OBSERVOU QUE A CRIANÇA AINDA NÃO FALAVA PALAVRAS COMPREENSÍVEIS, TINHA DIFICULDADE PARA CONSTRUIR TORRE DE TRÊS CUBOS E APONTAR PARA OBJETOS OU FIGURAS PRÓXIMAS. GABRIELA ESTAVA COM 9300g DE PESO; 79 CM DE COMPRIMENTO; ÍNDICE DE MASSA CORPORAL DE 14,9; PERÍMETRO CEFÁLICO DE 46 CM; PERÍMETRO BRAQUIAL DE 12,7 CM; PREGA CUTÂNEA TRICIPITAL DE 8,3 MM E PREGA CUTÂNEA SUBESCAPULAR DE 7,5 MM.  AO EXAME FÍSICO, GABRIELA MOSTROU-SE: INQUIETA, IRRITADA, AFEBRIL (36.2°C), HIPOCORADA (+/4+), PUPILAS ISOCÓRICAS, FOTORREAGENTES, ESCLERÓTICA ANICTÉRICA. PAVILHÃO AURICULAR INDOLOR À PRESSÃO NA REGIÃO DO TRAGUS, AUSÊNCIA DE SECREÇÃO NO CONDUTO AUDITIVO EXTERNO. CAVIDADE ORAL SEM ANORMALIDADES, GENGIVAS HIPOCORADAS (+/4+). LINFONODOS AURICULARES, OCCIPITAIS, SUBMANDIBULARES, CERVICAIS, AXILARES E INGUINAIS IMPALPÁVEIS. TÓRAX SIMÉTRICO COM EXPANSÃO BILATERAL, EUPNEICA (FR 29 RPM), PRESENÇA DE MURMÚRIOS VESICULARES EM AMBOS OS HEMITÓRAX SEM RUÍDOS ADVENTÍCIOS. NORMOCÁRDICA (FC 110 BPM), RITMO CARDÍACO REGULAR, BULHAS NORMOFONÉTICAS EM 2 TEMPOS, BOA PERFUSÃO TISSULAR PERIFÉRICA. ABDÔMEM PLANO, TIMPÂNICO, INDOLOR À PALPAÇÃO, RUÍDOS HIDROÁREOS PRESENTES, CICATRIZ UMBILICAL ÍNTEGRA. MEMBROS SUPERIORES E INFERIORES SIMÉTRICOS COM TONO E FORÇA MUSCULARES PRESERVADOS. PRESENÇA DE HEMATOMAS EM AMBOS OS BRAÇOS E PERNAS. GENITÁLIA TÍPICA FEMININA SEM ANORMALIDADES. ÚLCERAS CONFLUENTES COM MODERADA EXSUDAÇÃO EM REGIÃO GLÚTEA, ESTÁGIO III, CICATRIZANDO POR 2ª INTENÇÃO, REGIÃO PERILESIONAL MACERADA COM ÁREAS DE EPITELIZAÇÃO, BORDAS IRREGULARES COM MARGENS ADERIDAS, LEITO COM PRESENÇA DE TECIDO DE GRANULAÇÃO.", 
					imagensEc3, imgsAux3, "", curso);
			Fachada.getInstancia().cadastrarEstudoDeCaso(estudo3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sf.getCurrentSession().getTransaction().commit();
	}
	
	public static void execCadastrarDeterminateHiposteses(){
		SessionFactory sf = HibernateUtil.getFabricaDeSessao();
		sf.getCurrentSession().beginTransaction();
		try {
			
//			DeterminanteHipoteses det = new DeterminanteHipoteses("Aleitamento materno misto e complementado", new EstudoDeCaso(2));
//			DeterminanteHipoteses det2 = new DeterminanteHipoteses("Técnica segura de amamentação", new EstudoDeCaso(2));
//			DeterminanteHipoteses det3 = new DeterminanteHipoteses("O cuidado centrado na família e na criança", new EstudoDeCaso(2));
//			DeterminanteHipoteses det4 = new DeterminanteHipoteses("Formação de rede de apoio social", new EstudoDeCaso(2));
//			DeterminanteHipoteses det5 = new DeterminanteHipoteses("Desenvolvimento da relação de vínculo/apego", new EstudoDeCaso(2));
//			DeterminanteHipoteses det6 = new DeterminanteHipoteses("Nutrição inadequada do lactente e sua relação com o atraso no crescimento e desenvolvimento infantil", new EstudoDeCaso(2));
//			
//			
//			DeterminanteHipoteses det7 = new DeterminanteHipoteses("Violência intradomiciliar", new EstudoDeCaso(3));
//			DeterminanteHipoteses det8 = new DeterminanteHipoteses("As ações da equipe multiprofissional no acolhimento e cuidado das crianças vítimas de violência", new EstudoDeCaso(3));
//			DeterminanteHipoteses det9 = new DeterminanteHipoteses("Atraso no crescimento e desenvolvimento infantil e sua relação com a violência intradomiciliar", new EstudoDeCaso(3));
//			DeterminanteHipoteses det13 = new DeterminanteHipoteses("Lesão de pele", new EstudoDeCaso(3));
//			DeterminanteHipoteses det23 = new DeterminanteHipoteses("Dependência química (álcool)", new EstudoDeCaso(3));
//			DeterminanteHipoteses det33 = new DeterminanteHipoteses("Formação de rede de proteção social", new EstudoDeCaso(3));
//			DeterminanteHipoteses det43 = new DeterminanteHipoteses("Cuidado centrado na família", new EstudoDeCaso(3));
//			DeterminanteHipoteses det53 = new DeterminanteHipoteses("Nutrição da criança inadequada", new EstudoDeCaso(3));
//			DeterminanteHipoteses det63 = new DeterminanteHipoteses("Higiene do ambiente e do corpo", new EstudoDeCaso(3));
//			DeterminanteHipoteses det73 = new DeterminanteHipoteses("Calendário vacinal da criança", new EstudoDeCaso(3));
//			
//			
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det2);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det3);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det4);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det5);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det6);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det7);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det8);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det9);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det13);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det23);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det33);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det43);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det53);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det63);
//			Fachada.getInstancia().adicionarDeterminanteHipoteses(det73);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		sf.getCurrentSession().getTransaction().commit();
	}
	
	public static void execCadastrarFeedBacksProfessor(){
		SessionFactory sf = HibernateUtil.getFabricaDeSessao();
		sf.getCurrentSession().beginTransaction();
		try {
			Planejamento pontos = new Planejamento();
			pontos.setId(1);
			AvaliacaoProfessor avaliacao = new AvaliacaoProfessor("A", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. ");
			pontos.setAvaliacaoProfessor(avaliacao);
			
			AvaliacaoProfessor avaliacao2 = new AvaliacaoProfessor("C", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. ");
			Implementacao teorizacao = new Implementacao();
			teorizacao.setId(1);
			teorizacao.setAvaliacaoProfessor(avaliacao2);
			
			AvaliacaoProfessor avaliacao3 = new AvaliacaoProfessor("B", "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. ");
			ResultadosEsperados hipoteses = new ResultadosEsperados();
			hipoteses.setId(1);
			hipoteses.setAvaliacaoProfessor(avaliacao3);
			
			Fachada.getInstancia().inserirAvaliacaoProfessor(avaliacao);
			Fachada.getInstancia().inserirAvaliacaoProfessor(avaliacao2);
			Fachada.getInstancia().inserirAvaliacaoProfessor(avaliacao3);
			Fachada.getInstancia().atualizarPontosChave(pontos);
			Fachada.getInstancia().atualizarTeorizacao(teorizacao);
			Fachada.getInstancia().atualizarHipotesesDeSolucao(hipoteses);
		}catch(Exception e){
			e.printStackTrace();
		}
		sf.getCurrentSession().getTransaction().commit();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		MainPopulaBD.execMainPopulaBD();
//		MainPopulaBD.execPopulaMateriais();
//		MainPopulaBD.execCriarArqvsCurso();
//		MainPopulaBD.execCadastrarEstudosDeCasos();
		MainPopulaBD.execCadastrarDeterminateHiposteses();
//		MainPopulaBD.execCadastrarFeedBacksProfessor();
	}

}
