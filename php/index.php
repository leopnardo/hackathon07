<?php

?>

<!DOCTYPE html>
<html>
<head>
	<title>Faculdade ALFA Umuarama - FAU - Faculdade ALFA UMuarama</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-title" content="Faculdade ALFA Umuarama">
	<meta name="description" content="FAU - Faculdade ALFA UMuarama">
	<meta name="keywords" content="graduacao, pos, marketing, sistemas, processos, internet, administração, gestão, umuarama, tecnologia, tecnologo, superior, webdev, pedagogia">
	<meta name="author" content="Grupo de Ensino - Alfa">


	<!-- facebook -->
	<meta property="og:title" content="Faculdade ALFA Umuarama">
	<meta property="og:type" content="School">
	<meta property="og:url" content="https://www.alfaumuarama.edu.br/">
	<meta property="og:image" content="https://www.alfaumuarama.edu.br/fau/imagens/media.jpg?v=1">

	<!-- css -->
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../css/all.min.css">
	<link rel="stylesheet" type="text/css" href="../css/fontawesome-all.min.css">
	<link rel="stylesheet" type="text/css" href="../css/cursos.css">
	<link rel="stylesheet" type="text/css" href="../css/lightbox.css">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link rel="stylesheet" href="../css/animate.css">


	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">

	<link rel="shortcut icon" href="../icons/icon.png">

	<link rel="apple-touch-icon" href="../icons/icon.png">
	<link rel="apple-touch-icon" sizes="152x152" href="../icons/icon-152.png">
	<link rel="apple-touch-icon" sizes="167x167" href="../icons/icon-167.png">
	<link rel="apple-touch-icon" sizes="180x180" href="../icons/icon-180.png">

	<link rel="apple-touch-startup-image" href="../images/logo.png">


	<!-- scripts -->
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="../js/popper.min.js"></script>
	<script type="text/javascript" src="../js/jquery.cycle2.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/jquery.inputmask.min.js" async></script>
	<script type="text/javascript" src="../js/bindings/inputmask.binding.js" async></script>

	<script type="text/javascript" src="../js/parsley.min.js" async></script>
	<script src='https://www.google.com/recaptcha/api.js?hl=pt-BR' async></script>
	<script type="text/javascript" src="../js/lightbox.js" async></script>

	<script src="../js/bootstrap.bundle.min.js"></script>
	<script src="../js/wow.min.js"></script>

	<script src="../js/jquery.min.js"></script>
	<script src="../js/moment.min.js"></script>
	<script src="../js/index.global.min.js"></script>
	<script src="../js/core/locales/pt-br.global.min.js"></script>

	<!-- script do calendário -->
	<script>
  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'multiMonthYear,dayGridMonth,timeGridWeek'
      },
      initialView: 'dayGridMonth',
      editable: false,
      selectable: true,
	  locale: 'pt-br',
      dayMaxEvents: true,
      events: 'http://localhost:3000/api/events',
	  eventClick: function (info) {
		const visualizarModal = new bootstrap.Modal(document.getElementById("visualizarModal"));
		visualizarModal.show();
		document.getElementById("visualizar_title").innerText = info.event.title;
		document.getElementById("visualizar_start").innerText = info.event.start.toLocaleString();
		document.getElementById("visualizar_end").innerText = info.event.end !== null ? info.event.end.toLocaleString() : "Não informado";
		document.getElementById("visualizar_speaker").innerText = info.event.extendedProps.speaker;
		document.getElementById("visualizar_curriculum").innerText = info.event.extendedProps.curriculum;
		document.getElementById("visualizar_theme").innerText = info.event.extendedProps.theme;
		const photoPath = event.photo ? `../images/events/${event.photo}` : '../images/events/null.png';
		document.getElementById('visualizar_photo').src = photoPath;
		document.getElementById("inscrever").href = "../php/inscrever.php?id=" + info.event.id;



	}
    });

    calendar.render();
  });
    </script>

	<script type="text/javascript" src="https://platform.twitter.com/widgets.js" async></script>
	<script src="https://connect.facebook.net/pt_BR/all.js#xfbml=1" async></script>
	<script type="text/javascript" async src="https://d335luupugsy2.cloudfront.net/js/loader-scripts/9f98cc79-8e2d-4da5-9e81-03339d188480-loader.js"></script>

	<script type="text/javascript">
		window.dataLayer = window.dataLayer || [];

		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-124835913-1');
	</script>

	<!-- Facebook Pixel Code -->
	<!-- Meta Pixel Code -->
	<script>
		! function(f, b, e, v, n, t, s) {
			if (f.fbq) return;
			n = f.fbq = function() {
				n.callMethod ?
					n.callMethod.apply(n, arguments) : n.queue.push(arguments)
			};
			if (!f._fbq) f._fbq = n;
			n.push = n;
			n.loaded = !0;
			n.version = '2.0';
			n.queue = [];
			t = b.createElement(e);
			t.async = !0;
			t.src = v;
			s = b.getElementsByTagName(e)[0];
			s.parentNode.insertBefore(t, s)
		}(window, document, 'script',
			'https://connect.facebook.net/en_US/fbevents.js');
		fbq('init', '1265641737181789');
		fbq('track', 'PageView');
	</script>
	<noscript><img height="1" width="1" style="display:none" src="https://www.facebook.com/tr?id=1265641737181789&ev=PageView&noscript=1" /></noscript>
	<!-- End Meta Pixel Code -->
	<!-- End Facebook Pixel Code -->

</head>

<body>

	<header>
		<div class="top">

			<div class="line" style="padding: 10px; box-sizing:border-box;">
				<div class="float-left">
					<span><i class="fas fa-phone"></i> Disk Vestibular: (44) 3622-2500</span>
					<span><i class="fas fa-envelope"></i> <a href="https://www.alfaumuarama.edu.br/fau/contato" title="Contato">Contato</a></span>
				</div>
				<div class="float-right">
					<span class="dropdown">
						<a href="javascript:window.open('https://mail.google.com/a/alfaumuarama.edu.br','_blank')" class="link">
							Webmail</a>
					</span> |
					<a href="https://omegasistema166700.rm.cloudtotvs.com.br/FrameHTML/Web/App/Edu/PortalEducacional" title="Portal do Aluno" target="_blank"> Portal do Aluno TOTVS</a> |

					<a href="https://omegasistema166700.rm.cloudtotvs.com.br/FrameHTML/Web/App/Edu/PortalDoProfessor" title="Aluno e Professor Online" target="_blank"> Portal do Professor TOTVS</a> |

					<!--<span class="dropdown">
							<a href="#" class="link dropdown-toggle" role="button" id="dropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Aluno e Professor Online</a> 
							<div class="dropdown-menu popup" aria-labelledby="dropdownMenuLink">
								<form action="https://alfa.matheusacademico.com.br/login.asp" name="loginAluno" id="loginAluno" method="post" target="_blank">
									<input type="hidden" name="tipo_login" value="1">
									<input type="text" name="txtusuario" class="form-control" placeholder="Usuário ou CPF">
									<br>
									<input type="password" name="txtsenha"  class="form-control" placeholder="Senha">
									<br>
									<p class="text-center" style="margin:5px;"><button type="submit" class="btn btn-success"><i class="fas fa-check"></i> Efetuar Login</button>
										<br>
										<a href="https://alfa.matheusacademico.com.br/frmesqueceu.asp" target="_blank" title="Esqueci minha senha">
											Esqueci minha senha
										</a>
									</p>
								</form>
							</div>
						</span> |-->
					<!-- <a href="https://www.alfaumuarama.edu.br/academico" title="Ambiente Virtual de Aprendizagem">AVA</a>-->
					<span class="dropdown">
						<a href="#" class="link dropdown-toggle" role="button" id="dropdownMenuLinkAva" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">AVA</a>
						<div class="dropdown-menu popup" aria-labelledby="dropdownMenuLinkAva" style="font-size: 14px">
							<a class="dropdown-item" href="https://moodle.alfaumuarama.edu.br/login/index.php" target="_blank">EAD Moodle</a>
							<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/academico" target="_blank">Alunos Trabalhos</a>
							<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/academico/professor" target="_blank">Professor Trabalhos</a>
						</div>
					</span>
					|
					<span class="dropdown">
						<a href="#" class="link dropdown-toggle" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Biblioteca Virtual Pearson</a>
						<div class="dropdown-menu popup" aria-labelledby="dropdownMenuLink">
							<form action="https://plataforma.bvirtual.com.br/Account/Login/" name="loginProfessor" id="loginBiblioteca" method="post" target="_blank">

								<input type="text" name="UserName" class="form-control" placeholder="Usuário">
								<br>
								<input type="password" name="Password" class="form-control" placeholder="Senha">
								<br>
								<p class="text-center" style="margin:5px;"><button type="submit" class="btn btn-success"><i class="fas fa-check"></i> Efetuar Login</button>

								</p>
							</form>
						</div>
					</span> |
					<span class="dropdown">
						<a href="#" class="link dropdown-toggle" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Revista Jurídica</a>
						<div class="dropdown-menu popup" aria-labelledby="dropdownMenuLink">
							<form action="https://signon.thomsonreuters.com/?productid=WLBR&amp;returnto=https://www.revistadostribunais.com.br/maf/app/authentication/signon&amp;bhcp=1" id="form0" method="post" target="_blank">

								<input type="text" name="Username" class="form-control" placeholder="Usuário" required>
								<br>
								<input type="password" name="Password" class="form-control" placeholder="Senha" required>
								<br>
								<p class="text-center" style="margin:5px;"><button type="submit" class="btn btn-success"><i class="fas fa-check"></i> Efetuar Login</button>

								</p>
							</form>
						</div>
					</span> |
					<a href="https://proview.thomsonreuters.com/library.html?Sponsor=OSEP-1" title="Biblioteca Digital Proview" target="_blank" rel="noreferrer">Biblioteca Digital Proview</a>
				</div>
			</div>

		</div>
		<div class="clearfix"></div>
		<nav class="navbar navbar-expand-lg navbar-light">

			<a class="navbar-brand" href="https://www.alfaumuarama.edu.br/fau/index.php" title="FAU - Faculdade ALFA">
				<img src="../images/logo_novo.png" alt="FAU" title="FAU">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu" aria-controls="menu" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="menu">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Institucional
						</a>
						<div class="dropdown-menu dropdown-institucional" aria-labelledby="navbarDropdown">
							<img src="../images/alfa.jpg" alt="FAU" title="FAU" class="w-100">
							<div class="row">
								<div class="col-md-6">
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/sobre/institucional">Sobre a Faculdade</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/sobre/estrutura-administrativa">Estrutura Administrativa</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/sobre/estrutura-fisica">Estrutura Física</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/sobre/documentos">Documentos Institucionais</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/sobre/financiamento">Programa de Financiamento</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/programa-de-descontos">Programa de Descontos</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/enem">Ingresse com a nota do ENEM</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/sobre/cpa">Avaliação Institucional</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/sobre/carreira">Carreira e Capacitação</a>

								</div>
								<div class="col-md-6">
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/sobre/empresajr">Empresa Júnior</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/sobre/biblioteca">Biblioteca Digital</a>
									<a class="dropdown-item" href="http://revista.alfaumuarama.edu.br" target="_blank">Revista Scientia Alpha</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/sobre/projetos-academicos">Projetos Acadêmicos</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/sobre/egressos">Egressos</a>
									<a class="dropdown-item" href="../php/index.php">Eventos</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/galerias">Galeria de Fotos</a>
									<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/blog">Blog</a>
									<a class="dropdown-item" style="font-weight: bold" href="https://www.alfaumuarama.edu.br/fau/cursos-capacitacao">Cursos de Capacitação</a>
								</div>
							</div>


						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Educação Presencial
						</a>
						<div class="dropdown-menu dropdown-cursos" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/cursos-graduacao">Cursos de Graduação</a>
							<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/cursos-pos">Cursos de Pós-Graduação</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="https://vestibular.alfaumuarama.edu.br/">Inscrição no Vestibular</a>
							<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/resultado">Resultado do Vestibular</a>
							<a class="dropdown-item" href="https://vestibular.alfaumuarama.edu.br/">Vestibular Online</a>
							<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/programa-de-descontos">Programa de Descontos UniALFA</a>
							<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/enem">Como ganhar bolsas de até <br>100% com a nota do ENEM</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/cursos-capacitacao">Cursos de Capacitação</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Educação a Distância - EAD
						</a>
						<div class="dropdown-menu dropdown-cursos" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/educacao-distancia-graduacao">Cursos de Graduação</a>
							<a class="dropdown-item" href="https://www.alfaumuarama.edu.br/fau/educacao-distancia-pos">Cursos de Pós-Graduação</a>
						</div>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="https://www.alfaumuarama.edu.br/fau/blog">Blog</a>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Demais Serviços
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="javascript:window.open('https://ead.unifatecie.edu.br/')"> Polo UniFatecie EAD</a>
							<a class="dropdown-item" href="javascript:window.open('https://www.treineinga.com.br/')">Polo Treine Ingá Cursos Imobiliários</a>

						</div>
					</li>
					<li class="nav-item">
						<a class="nav-link vestibular" href="https://vestibular.alfaumuarama.edu.br/">Inscreva-se!</a>
					</li>
				</ul>
			</div>

		</nav>
	</header>

	<main>
			<div class="header downloads">
		<div class="container">
			<h1>Listagem de eventos</h1>
		</div>
	</div>

<!-- div do calendario -->
 <h1>Calendário</h1>
	<div id='calendar'></div>

<!-- modal visualizar dos eventos no bootstrap -->
<div class="modal fade" id="visualizarModal" tabindex="-1" aria-labelledby="visualizarModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="visualizarModalLabel">Detalhes do Evento</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <dl class="row">

  <dt class="col-sm-3">Título:</dt>
  <dd class="col-sm-9" id="visualizar_title"></dd>

    <dt class="col-sm-3">Início:</dt>
  <dd class="col-sm-9" id="visualizar_start"></dd>

    <dt class="col-sm-3">Fim:</dt>
  <dd class="col-sm-9" id="visualizar_end"></dd>

      <dt class="col-sm-3">Palestrante:</dt>
  <dd class="col-sm-9" id="visualizar_speaker"></dd>

      <dt class="col-sm-3">Minicurrículo:</dt>
  <dd class="col-sm-9" id="visualizar_curriculum"></dd>

      <dt class="col-sm-3">Tema:</dt>
  <dd class="col-sm-9" id="visualizar_theme"></dd>

      <dt class="col-sm-3">Foto:</dt>
  <dd class="col-sm-9"><img id="visualizar_photo" class="img-fluid" /></dd>


</dl>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Voltar</button>
        <a href="#" id="inscrever" class="btn btn-primary">Inscreva-se</a>
      </div>
    </div>
  </div>
</div>

	<footer>
		<div class="footer-top">
			<div class="container">
				<div class="row">
					<div class="col-12 col-sm-6 col-lg-3 col-xl-3">
						<a href="https://www.alfaumuarama.edu.br/fau/sobre/institucional" title="Conheça a FAU"><i class="fas fa-search"></i> Conheça a UniALFA</a>
					</div>

					<div class="col-12 col-sm-6 col-lg-3 col-xl-3">
						<a href="https://www.alfaumuarama.edu.br/fau/trabalhe-conosco" title="Trabalhe Conosco"><i class="fas fa-briefcase"></i> Trabalhe Conosco</a>
					</div>
					<div class="col-12 col-sm-6 col-lg-3 col-xl-3">
						<a href="https://www.alfaumuarama.edu.br/fau/mapa-site" title="Mapa do Site"><i class="fas fa-map-marked-alt"></i> Mapa do Site</a>
					</div>
					<div class="col-12 col-sm-6 col-lg-3 col-xl-3">
						<a href="https://www.alfaumuarama.edu.br/fau/contato" title="Central de Atendimento"><i class="fas fa-headphones-alt"></i> Central de Atendimento</a>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-middle">
			<div class="container">
				<div class="row">
					<div class="col-12 col-sm-12 col-lg-2 col-xl-2">
						<a href="https://www.alfaumuarama.edu.br/fau/index.php" title="FAU">
							<img src="../images/logop.png" alt="FAU" title="FAU" class="w-100">
						</a>
						<p class="text-center">
							<a href="https://emec.mec.gov.br/emec/consulta-cadastro/detalhamento/d96957f455f6405d14c6542552b0f6eb/NDc2NQ==" title="Consulte no E-mec" target="_blank"><img src="../images/qr.jpg" alt="Consulte o cadastro da IES no e-MEC" title="Consulte o cadastro da IES no e-MEC" class="w-100"></a>
							<br>
							Consulte o cadastro da IES no e-MEC
						</p>
					</div>
					<div class="col-12 col-sm-6 col-xl-3 col-lg-3">
						<p><strong>Sobre</strong></p>
						<!--formas-ingresso-->
						<p>
							<a href="https://www.alfaumuarama.edu.br/fau/sobre/institucional" title="Sobre a UniALFA">> Sobre a UniALFA</a><br>
							<a href="https://www.alfaumuarama.edu.br/fau/sobre/estrutura-fisica" title="Estrutura">> Estrutura</a><br>
							<a href="https://www.alfaumuarama.edu.br/fau/sobre/localizacao" title="Localização">> Localização</a><br>
							<a href="https://vestibular.alfaumuarama.edu.br/" title="Vestibular">> Vestibular</a><br>
							<a href="https://www.alfaumuarama.edu.br/fau/cursos-capacitacao" title="Cursos de Capacitação">> Cursos de Capacitação</a><br>
							<a href="https://vestibular.alfaumuarama.edu.br//" title="Formas de Ingresso">> Formas de Ingresso</a><br>
							<a href="https://www.alfaumuarama.edu.br/fau/sobre/financiamento" title="Financiamento Estudantil">> Financiamento Estudantil</a><br>
							<a href="https://www.alfaumuarama.edu.br/fau/downloads" title="Downloads">> Downloads</a><br>
							<a href="https://www.alfaumuarama.edu.br/fau/politica-de-privacidade" title="Política de Privacidade">> Política de Privacidade</a><br>
							<a href="https://www.alfaumuarama.edu.br/fau/contato" title="Ouvidoria">> Ouvidoria</a><br>
						</p>
					</div>
					<div class="col-12 col-sm-6 col-xl-3 col-lg-3">
						<p><strong>Cursos de Graduação</strong></p>

						<p>
							<a href="https://www.alfaumuarama.edu.br/fau/graduacao/8142/administracao" title="Administração">> Administração</a><br><a href="https://www.alfaumuarama.edu.br/fau/graduacao/8143/ciencias-contabeis" title="Ciências Contábeis">> Ciências Contábeis</a><br><a href="https://www.alfaumuarama.edu.br/fau/graduacao/8176/direito" title="Direito">> Direito</a><br><a href="https://www.alfaumuarama.edu.br/fau/graduacao/8179/gestao-hospitalar" title="Gestão Hospitalar">> Gestão Hospitalar</a><br><a href="https://www.alfaumuarama.edu.br/fau/graduacao/1/marketing" title="Marketing">> Marketing</a><br><a href="https://www.alfaumuarama.edu.br/fau/graduacao/8141/pedagogia" title="Pedagogia">> Pedagogia</a><br><a href="https://www.alfaumuarama.edu.br/fau/graduacao/3/processos-gerenciais" title="Processos Gerenciais">> Processos Gerenciais</a><br><a href="https://www.alfaumuarama.edu.br/fau/graduacao/8177/psicologia-" title="Psicologia ">> Psicologia </a><br><a href="https://www.alfaumuarama.edu.br/fau/graduacao/8178/recursos-humanos" title="Recursos Humanos">> Recursos Humanos</a><br><a href="https://www.alfaumuarama.edu.br/fau/graduacao/2/sistemas-para-internet" title="Sistemas para Internet">> Sistemas para Internet</a><br>
						</p>

						<p><strong><a href="https://pos.alfaumuarama.edu.br" title="Pós-Graduação">Cursos de Pós-Graduação</a></strong></p>

						<p>
													</p>
					</div>
					<div class="col-12 col-sm-12 col-xl-4 col-lg-4 infos">

						<p>

							<i class="fas fa-map-marker-alt fa-2x float-left"></i>
							<span>Av. Paraná 7327, Zona III,
								CEP 87502-000, Umuarama - PR</span>
							<br><br>
						</p>
						<div class="clearfix"></div>

						<p>
							<i class="fab fa-whatsapp fa-2x float-left"></i>
							<span><a href="https://api.whatsapp.com/send?phone=554436222500"> (44) 36222500 WhatsApp</a></span>
						</p>

						<div class="clearfix"></div>
						<br><br>
						<p class="text-center">
							<a href="https://vestibular.alfaumuarama.edu.br/" title="Inscreva-se" class="btn btn-success btn-lg">
								Inscreva-se no Vestibular!
							</a>
						</p>

					</div>
				</div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<p class="float-left">
					Faculdade ALFA Umuarama - UniALFA - 2025 - Todos os direitos reservados
				</p>
				<p class="float-right text-right">
					<a href="https://www.alfaumuarama.edu.br/fau/contato" title="Entre em Contato">
						<i class="far fa-envelope"></i>
					</a>
					<a href="javascript:window.open('https://www.youtube.com/channel/UCDaf6TTBhHQg5hRNZ3lX8wg')" title="Visite a FAU no Youtube">
						<i class="fab fa-youtube"></i>
					</a>
					<a href="javascript:window.open('https://www.instagram.com/faculdadealfaumuarama/')" title="Visite a FAU no Instagram">
						<i class="fab fa-instagram"></i>
					</a>
					<a href="javascript:window.open('https://twitter.com/faculdadealfa')" title="Visite a FAU no Twitter">
						<i class="fab fa-twitter"></i>
					</a>
					<a href="javascript:window.open('https://www.facebook.com/faculdadeAlfaUmuarama/');" title="Visite a FAU no Facebook">
						<i class="fab fa-facebook-f"></i>
					</a>
				</p>
			</div>
		</div>
	</footer>

	<div style="position: fixed; width: 100%; background: rgba(0,0,0,0.8);padding: 30px; box-sizing: border-box; text-align: center; color: #FFF; bottom: 0px; z-index:999;display:none;" id="aviso">
		<p class="text-center">O site da UniALFA - Faculdade ALFA Umuarama utiliza cookies para melhorar sua experiência na nagevação. Saiba mais visitando nossas <a href="https://www.alfaumuarama.edu.br/fau/politica-de-privacidade" title="Política de Privacidade"><u>políticas de privacidade</u></a>. <br>Ao continuar navegando, você aceita nossas condições.</p>
		<p class="text-center"><a href="javascript:continuar()" class="btn btn-success">Clique aqui para prosseguir</a></p>
	</div>

	<script>
		function continuar() {
			document.getElementById('aviso').style.display = 'none';
			localStorage.setItem("aviso", "ok");
		}

		var m = localStorage.getItem("aviso");

		console.log(m);

		if (m != "ok") {
			document.getElementById('aviso').style.display = 'block';

		}
	</script>

	<a id="whats" class="bricks--floating--button rdstation-popup-js-floating-button shake" href="https://api.whatsapp.com/send?phone=554436222500" target="_whats"></a>

	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id)) return;
			js = d.createElement(s);
			js.id = id;
			js.src = 'https://connect.facebook.net/pt_BR/all.js#xfbml=1';
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<script>
		$(document).ready(function() {
			new WOW().init();
		});
	</script>
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-124835913-1"></script>
	<script>
		$(document).ready(function() {
			$(":input").inputmask();

			$(".mask").focus(function() {
				$(this).selectRange(0, 0);
			});
			$(".mask").click(function() {
				$(this).selectRange(0, 0);
			});

			$.fn.selectRange = function(start, end) {
				return this.each(function() {
					if (this.setSelectionRange) {
						this.focus();
						this.setSelectionRange(start, end);
					} else if (this.createTextRange) {
						var range = this.createTextRange();
						range.collapse(true);
						range.moveEnd('character', end);
						range.moveStart('character', start);
						range.select();
					}
				});
			};
		})
	</script>


</body>
</html>