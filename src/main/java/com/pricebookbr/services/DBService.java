package com.pricebookbr.services;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pricebookbr.domain.Categoria;
import com.pricebookbr.domain.Classificacao;
import com.pricebookbr.domain.Cliente;
import com.pricebookbr.domain.Marca;
import com.pricebookbr.domain.Produto;
import com.pricebookbr.domain.enums.Perfil;
import com.pricebookbr.domain.enums.SituacaoImagem;
import com.pricebookbr.repositories.CategoriaRepository;
import com.pricebookbr.repositories.ClassificacaoRepository;
import com.pricebookbr.repositories.ClienteRepository;
import com.pricebookbr.repositories.MarcaRepository;
import com.pricebookbr.repositories.ProdutoRepository;

@Service
public class DBService {
	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

//	@Autowired
//	private CidadeRepository cidadeRepository;

//	@Autowired
//	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	//@Autowired
	//private EnderecoRepository enderecoRepository;

	//@Autowired
	//private PedidoRepository pedidoRepository;

	//@Autowired
	//private PagamentoRepository pagamentoRepository;

	//@Autowired
	//private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private ClassificacaoRepository classificacaoRepository;
	
	public void instantiateDevDatabase() throws ParseException {
		instantiateTestPriceBookDatabase();
	}
	
	public void instantiateTestDatabase() throws ParseException {
		// instantiateTestCursoDatabase();
		// instantiateTestBenditoPastelDatabase();
		//instantiateTestTilapiaRCSDatabase();
		instantiateTestPriceBookDatabase();
	}

	public void instantiateHomDatabase() throws ParseException {
		instantiateTestPriceBookDatabase();
	}

	public void instantiateTestPriceBookDatabase() throws ParseException {
		// Cadastro de Estados
		//Estado est01 = new Estado(null, "Distrito Federal");

		// Cidades para o Estado do Distrito Federal
		//Cidade cid01 = new Cidade(null, "Bras??lia", est01);
		//Cidade cid02 = new Cidade(null, "Riacho Fundo", est01);
		//Cidade cid03 = new Cidade(null, "Candangol??ndia", est01);
		//Cidade cid04 = new Cidade(null, "Samambaia", est01);
		//Cidade cid05 = new Cidade(null, "Guar??", est01);
		//Cidade cid06 = new Cidade(null, "S??o Sebasti??o", est01);
		//Cidade cid07 = new Cidade(null, "Ceil??ndia", est01);
		//Cidade cid08 = new Cidade(null, "Lago Norte", est01);
		//Cidade cid09 = new Cidade(null, "Sobradinho", est01);
		//Cidade cid10 = new Cidade(null, "Lago Sul", est01);
		//Cidade cid11 = new Cidade(null, "Gama", est01);
		//Cidade cid12 = new Cidade(null, "Santa Maria", est01);
		//Cidade cid13 = new Cidade(null, "Taguatinga", est01);
		//Cidade cid14 = new Cidade(null, "Planaltina", est01);
		//Cidade cid15 = new Cidade(null, "Recanto das Emas", est01);
		//Cidade cid16 = new Cidade(null, "Cruzeiro", est01);
		//Cidade cid17 = new Cidade(null, "Brazl??ndia", est01);
		//Cidade cid18 = new Cidade(null, "Parano??", est01);
		//Cidade cid19 = new Cidade(null, "N??cleo Bandeirante", est01);

		// Vincula as Cidades aos Estados

		// Distrito Federal
		//est01.getCidades().addAll(Arrays.asList(cid01, cid02, cid03, cid04, cid05, cid06, cid07, cid08, cid09, cid10,
		//		cid11, cid12, cid13, cid14, cid15, cid16, cid17, cid18, cid19));

		// Salva Estados e Cidades no banco de dados
		//estadoRepository.saveAll(Arrays.asList(est01));
		//cidadeRepository.saveAll(Arrays.asList(cid01, cid02, cid03, cid04, cid05, cid06, cid07, cid08, cid09, cid10,
		//		cid11, cid12, cid13, cid14, cid15, cid16, cid17, cid18, cid19));

		// Cadastro de Clientes
		
		// Paulo Administrador
		Cliente cli01 = new Cliente(null, "Paulo melo", "paulo.melo@pricebook.com.br", 
				//"",	TipoCliente.PESSOAFISICA, 
				pe.encode("123"), new Date(), 0);
		//cli01.getTelefones().addAll(Arrays.asList("61996696526"));
		cli01.addPerfil(Perfil.ADMIN);

		// Alexandre Cliente
		Cliente cli02 = new Cliente(null, "Alexandre Soares de Almeida", "alexandre.almeida@pricebook.com.br", 
				//"64760537104", TipoCliente.PESSOAFISICA,
				pe.encode("123"), new Date(), 0);
		cli02.addPerfil(Perfil.ADMIN);
		//cli02.getTelefones().addAll(Arrays.asList("+5561992770876"));
		//cli02.addPerfil(Perfil.ADMIN);

		// Adicionar hist??rico de exemplo
		
		
		
//		Endereco e1 = new Endereco(null, "Quadra SQSW", "303", "Bloco B, Apto 503", "Sudoeste", "70673-302", cli01, cid01);
//		Endereco e2 = new Endereco(null, "QE 28 conjunto D", "26", "casa", "Guar?? II", "71060042", cli02, cid05);

//		cli01.getEnderecos().addAll(Arrays.asList(e1));
//		cli02.getEnderecos().addAll(Arrays.asList(e2));

		clienteRepository.saveAll(Arrays.asList(cli01, cli02));
//		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
		// CATEGORIAS EXISTENTES
		Categoria cat01 = new Categoria(null, "Gr??os e Cereais", "Nos gr??os de cereais podemos encontrar nutrientes como: carboidratos, prote??nas, gorduras, sais minerais, vitaminas, enzimas e outras subst??ncias.");
		Categoria cat02 = new Categoria(null, "Doces do Brasil",	"Iguarias brasileiras para todos os gostos.");

		//..............................................................................
		// Marcas Arroz 
		Marca mar01 = new Marca(null, "Tio Jo??o", "O arroz Tio Jo??o ?? produzido pela Josapar, uma das dez maiores empresas de produtos aliment??cios do Pa??s, que beneficia mais de 486 mil toneladas de gr??os por ano. A hist??ria da companhia come??ou nas primeiras d??cadas do s??culo XX, quando em 1911, o portugu??s Joaquim Oliveira chegou ?? cidade de Pelotas, no Rio Grande do Sul. Dono de um esp??rito empreendedor e um faro singular para os neg??cios, Joaquim viu na cidade que o recebeu a oportunidade de sua vida. E n??o era para menos! H?? mais de 90 anos no mercado, a Josapar solidificou-se n??o s?? pela qualidade de seus produtos, mas pelo compromisso com o cliente. Seus produtos est??o distribu??dos em todo o Brasil e em mais de 40 pa??ses da Am??rica do Norte, ??sia, ??frica e Europa.");
		Marca mar02 = new Marca(null, "Camil", "Uma das maiores empresas de alimentos da Am??rica do Sul, a Camil Alimentos iniciou sua trajet??ria no mercado nacional em 1963 como uma cooperativa de produtores de arroz. Com uma estrat??gia de neg??cios pautada pela diversifica????o do portf??lio, inova????o de produtos, aquisi????es estrat??gicas e expans??o para mercados externos, a Camil Alimentos ??, hoje, l??der em beneficiamento e comercializa????o de arroz no Brasil, Chile, Uruguai, Peru e Argentina. A companhia tamb??m det??m marcas l??deres de mercado e top of mind em suas categorias: Uni??o, Camil (arroz e feij??o) e Coqueiro (sardinha). Atualmente, a empresa possui 29 unidades de processamento e 18 centros de distribui????o no Brasil, Chile, Peru e Uruguai, exporta para mais de 50 pa??ses.");
		Marca mar03 = new Marca(null, "Cristal", "Nossa marca representa a confian??a e a prefer??ncia do consumidor. Todos os produtos da Cristal Alimentos s??o produzidos com rigorosos sistemas de controle de qualidade totalmente computadorizados.");
		Marca mar04 = new Marca(null, "Momiji", "O arroz para culin??ria oriental possui um sabor equilibrado e ?? pr??prio para o preparo de gohan (arroz japon??s), temakis e sushis, entre outras receitas.");
		
		// Marcas Feij??o
		Marca mar05 = new Marca(null, "Kicaldo", "Os produtos da marca Kicaldo s??o produzidos com toda a preocupa????o e aten????o em levar um alimento de qualidade para os brasileiros. Por isso, oferecemos uma variedade de alimentos que atendam suas necessidades e proporcionem uma refei????o mais saborosa para voc?? e sua fam??lia.");

		// Marcas Dpces
		Marca mar06 = new Marca(null, "Santa Helena", "De Ribeir??o Preto para o mundo, desde 1942 levamos alegria e sabor atrav??s de produtos de qualidade, sempre preocupados com a qualidade e a proced??ncia de toda mat??ria-prima que usamos.");

		//..............................................................................
		// Classificacoes
		Classificacao clas01 = new Classificacao(null, "classe longo fino", ".");
		Classificacao clas02 = new Classificacao(null, "classe longo", ".");
		Classificacao clas03 = new Classificacao(null, "classe parboilizado", ".");
		
		Classificacao clas04 = new Classificacao(null, "Carioca", "O Feij??o Carioca da marca Kicaldo ?? a melhor op????o para acompanhar o seu arroz, tornando a refei????o do brasileiro mais saborosa e saud??vel. Ele recebeu este nome por causa das suas listras, que lembram o cal??ad??o de Copacabana. Dispon??vel em pacotes de 1kg e fardos de 10kg e 30kg, na regi??o Sudeste, Nordeste, Centro-Oeste e Norte (exceto Roraima).");
		Classificacao clas05 = new Classificacao(null, "Preto", "O Feij??o Preto da marca Kicaldo fica ??timo na sua feijoada e nas refei????es di??rias da sua fam??lia, al??m de ser considerado um grande aliado no combate ao estresse, o Feij??o Preto ?? rico em vitaminas e minerais que ajudam a combater o des??nimo e proporcionam bem-estar para os brasileiros. Dispon??vel em pacotes de 1kg, e fardos de 10kg e 30kg, na regi??o Sudeste, Centro-Oeste, Nordeste, Norte (exceto Roraima), Sul (exceto Paran??).");
		Classificacao clas06 = new Classificacao(null, "Fradinho", "?? muito utilizado para acompanhar saladas e no preparo do tradicional acaraj??. O Feij??o Fradinho da marca Kicaldo ?? rico em fibras e muito nutritivo, tornando suas receitas em verdadeiros sucessos. Dispon??vel em pacotes de 1kg e fardos de 10kg, na regi??o Sudeste, Nordeste, Centro-Oeste, Norte (exceto Roraima) e no Paran??");

		Classificacao clas07 = new Classificacao(null, "Doce de amendoim", "integra os produtos apreciados por consumidores de todas as idades h?? mais de 25 anos.");
		
		//..............................................................................
		// Gr??os e Cereais
		
		// Arroz
		Produto p01 = new Produto(null, "Arroz", "Caracter??sticas do Arroz (Oryza sativa) O arroz cultivado ?? uma planta herb??cea inclu??da na classe Liliopsida (Monocotiled??nea), ordem Poales, fam??lia Poaceae, g??nero Oryza. ?? uma planta da fam??lia das gram??neas que alimenta mais da metade da popula????o humana.", 0.00, "7893500020158", "5Kg", "", cli01, new Date(), SituacaoImagem.ENCONTRADA.getCod(), 0 );
		//Produto p02 = new Produto(null, "Arroz", "Caracter??sticas do Arroz (Oryza sativa) O arroz cultivado ?? uma planta herb??cea inclu??da na classe Liliopsida (Monocotiled??nea), ordem Poales, fam??lia Poaceae, g??nero Oryza. ?? uma planta da fam??lia das gram??neas que alimenta mais da metade da popula????o humana.", 0.00, "7893500018452", "5Kg", "", cli01, new Date());
		//Produto p03 = new Produto(null, "Arroz", "Caracter??sticas do Arroz (Oryza sativa) O arroz cultivado ?? uma planta herb??cea inclu??da na classe Liliopsida (Monocotiled??nea), ordem Poales, fam??lia Poaceae, g??nero Oryza. ?? uma planta da fam??lia das gram??neas que alimenta mais da metade da popula????o humana.", 0.00, "7896006711155", "5Kg", "", cli01, new Date());
		//Produto p04 = new Produto(null, "Arroz", "Caracter??sticas do Arroz (Oryza sativa) O arroz cultivado ?? uma planta herb??cea inclu??da na classe Liliopsida (Monocotiled??nea), ordem Poales, fam??lia Poaceae, g??nero Oryza. ?? uma planta da fam??lia das gram??neas que alimenta mais da metade da popula????o humana.", 0.00, "7896212919888", "5Kg", "", cli01, new Date());
		//Produto p05 = new Produto(null, "Arroz", "Caracter??sticas do Arroz (Oryza sativa) O arroz cultivado ?? uma planta herb??cea inclu??da na classe Liliopsida (Monocotiled??nea), ordem Poales, fam??lia Poaceae, g??nero Oryza. ?? uma planta da fam??lia das gram??neas que alimenta mais da metade da popula????o humana.", 0.00, "7896006701156", "5Kg", "", cli01, new Date());

		
		// Feij??o
		//Produto p06 = new Produto(null, "Feij??o"," ?? um nome comum para uma grande variedade de sementes de plantas de alguns g??neros da fam??lia Fabaceae. Proporciona nutrientes essenciais como prote??nas, ferro, c??lcio, vitaminas (principalmente do complexo B), carboidratos e fibras.", 0.00, "7896116900029", "1Kg", "", cli01, new Date());
		//Produto p07 = new Produto(null, "Feij??o"," ?? um nome comum para uma grande variedade de sementes de plantas de alguns g??neros da fam??lia Fabaceae. Proporciona nutrientes essenciais como prote??nas, ferro, c??lcio, vitaminas (principalmente do complexo B), carboidratos e fibras.", 0.00, "7896116900050", "1Kg", "", cli01, new Date());
		//Produto p08 = new Produto(null, "Feij??o"," ?? um nome comum para uma grande variedade de sementes de plantas de alguns g??neros da fam??lia Fabaceae. Proporciona nutrientes essenciais como prote??nas, ferro, c??lcio, vitaminas (principalmente do complexo B), carboidratos e fibras.", 0.00, "7896116901385", "1Kg", "", cli01, new Date());

		// Doces
		//Produto p09 = new Produto(null, "Pa??oquita Rolha","Tradicional produto brasileiro ?? base de amendoim, a Pa??oquita ?? l??der nacional no seu segmento e conquista consumidores e clientes a cada dia.", 15.99, "7896336011383", "750g", "https://www.pacoquita.com.br/produtos/pacoquita-rolha-embalada-pote-750g", cli01, new Date());

		// Doces
		//cat02.getProdutos().addAll(Arrays.asList(p09));
		//mar06.getProdutos().addAll(Arrays.asList(p09));
		//clas04.getProdutos().addAll(Arrays.asList(p09));
		
		// Gr??os e Sementes
		// Arroz:
		//cat01.getProdutos().addAll(Arrays.asList(p01, p02, p03, p04, p05));
		
		//mar01.getProdutos().addAll(Arrays.asList(p01, p02)); // Arroz - Tio Jo??o
		//mar02.getProdutos().addAll(Arrays.asList(p03)); // Arroz - Camil
		//mar03.getProdutos().addAll(Arrays.asList(p04)); // Arroz - Cristal
		//mar04.getProdutos().addAll(Arrays.asList(p05)); // Arroz - Momiji
		
		//clas01.getProdutos().addAll(Arrays.asList(p01, p03, p04)); // Longo Fino
		//clas02.getProdutos().addAll(Arrays.asList(p05)); // Longo
		//clas03.getProdutos().addAll(Arrays.asList(p02)); // Parboilizado
		
		// Feij??o
		//clas04.getProdutos().addAll(Arrays.asList(p06)); // Carioca
		//clas05.getProdutos().addAll(Arrays.asList(p07)); // Preto
		//clas06.getProdutos().addAll(Arrays.asList(p08)); // Fradinho
		
		// Doces
		//clas07.getProdutos().addAll(Arrays.asList(p09)); // Doce de amendoim

		// Feij??o:
		//cat02.getProdutos().addAll(Arrays.asList(p06, p07, p08));

		// Vincular Categorias a Produtos
		//p01.getCategorias().add(cat01);
		//p02.getCategorias().add(cat01);
		//p03.getCategorias().add(cat01);
		//p04.getCategorias().add(cat01);
		//p05.getCategorias().add(cat01);
		//p06.getCategorias().add(cat02);
		//p07.getCategorias().add(cat02);
		//p08.getCategorias().add(cat02);
		
		// Vincular Marcas a Produtos
		//p01.getMarcas().add(mar01);
		//p02.getMarcas().add(mar01);
		//p03.getMarcas().add(mar02);
		//p04.getMarcas().add(mar03);
		//p05.getMarcas().add(mar04);		
		
		// Vincular Classifica????es a Produtos
		//p01.getClassificacoes().add(clas01);
		//p03.getClassificacoes().add(clas01);
		//p04.getClassificacoes().add(clas01);
		//p05.getClassificacoes().add(clas02);
		//p02.getClassificacoes().add(clas03);
		

		// Salva Categorias (Todas)
		categoriaRepository.saveAll(Arrays.asList(cat01, cat02));
		
		// Salva Marcas (Todas)
		marcaRepository.saveAll(Arrays.asList(mar01, mar02, mar03, mar04, mar05, mar06));

		// Salva Marcas (Todas)
		classificacaoRepository.saveAll(Arrays.asList(clas01, clas02, clas03, clas04, clas05, clas06, clas07));

		// Salva Produtos da Categoria Arroz
		//produtoRepository.saveAll(Arrays.asList(p01, p02, p03, p04, p05));

		// Salva Produtos da Categoria de Feij??o
		//produtoRepository.saveAll(Arrays.asList(p06, p07, p08));

		// Salva Produtos da Categoria de Doces
		//produtoRepository.saveAll(Arrays.asList(p09));
		
		p01.getCategorias().add(cat01);
		p01.getMarcas().add(mar01);
		p01.getClassificacoes().add(clas01);

		cat01.getProdutos().addAll(Arrays.asList(p01));
		mar01.getProdutos().addAll(Arrays.asList(p01)); // Arroz - Tio Jo??o
		clas01.getProdutos().addAll(Arrays.asList(p01)); // Longo Fino
		produtoRepository.saveAll(Arrays.asList(p01));
	}	
}