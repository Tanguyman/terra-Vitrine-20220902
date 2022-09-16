<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
<%@ page import="beans.SliderBean"%>
<%@ page import="beans.LivreDOrBean"%>
<%@ page import="beans.LivreDOrLogosBean"%>
<%@ page import="beans.OffresBean"%>
<%
ArrayList<SliderBean> sliders = (ArrayList) request.getAttribute("sliders");
ArrayList<LivreDOrBean> temoignages = (ArrayList) request.getAttribute("temoignages");
ArrayList<LivreDOrLogosBean> logosPartenaires = (ArrayList) request.getAttribute("logosPartenaires");
OffresBean offre1 = (OffresBean) request.getAttribute("offre1");
OffresBean offre2 = (OffresBean) request.getAttribute("offre2");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<!-- Meta Tags -->
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
	<title>${ coordonneesTerra.nom }</title>
	<!-- Favicon -->
    <link href="${ coordonneesTerra.logoURL }" rel="icon">
    <!-- Bundle -->
    <link href="vendor/css/bundle.min.css" rel="stylesheet">
    <!-- Plugin Css -->
    <link href="vendor/css/LineIcons.min.css" rel="stylesheet">
    <link href="vendor/css/line-awesome.min.css" rel="stylesheet">
    <link href="vendor/css/select2.min.css" rel="stylesheet">
    <link href="vendor/css/revolution-settings.min.css" rel="stylesheet">
    <link href="vendor/css/jquery.fancybox.min.css" rel="stylesheet">
    <link href="vendor/css/owl.carousel.min.css" rel="stylesheet">
    <link href="vendor/css/swiper.min.css" rel="stylesheet">
    <link href="vendor/css/cubeportfolio.min.css" rel="stylesheet">
    <link href="vendor/css/wow.css" rel="stylesheet">
    <!-- Style Sheet -->
    <link href="directory-listing/css/style-copie.css" rel="stylesheet">
    <link href="personal/css/page-animation.css" rel="stylesheet">
    <link href="personal/css/style.css" rel="stylesheet">
    <!-- Style Sheet index-digital-agency -->
    <link href="digital-agency/css/slick.css" rel="stylesheet">
    <link href="digital-agency/css/slick-theme.css" rel="stylesheet">
    <link href="digital-agency/css/style-copie.css" rel="stylesheet">
    <!-- Style Sheet index-directory-listing -->
    <!-- <link href="directory-listing/css/bootstrap-select.min.css" rel="stylesheet"> -->
    <!-- <link href="directory-listing/css/sweetalert2.min.css" rel="stylesheet"> -->
    <!-- Style Sheet elements-portfolio--5 -->
    <link href="vendor/css/elements.css" rel="stylesheet">
</head>
<body class="signle-layout">

<!-- Preloader -->
<div class="preloader">
    <div class="centrize full-width">
        <div class="vertical-center">

            <svg class="ha-logo loading"
                 xmlns="http://www.w3.org/2000/svg"
                 viewBox="0 0 10 10">
                <path class="house"
                      d="M1.9 8.5V5.3h-1l4-4.3 2.2
       2.1v-.6h1v1.7l1 1.1H7.9v3.2z"   />
                <path class="circut"
                      d="M5 8.5V4m0 3.5l1.6-1.6V4.3M5
       6.3L3.5 4.9v-.6m2.7.7l.4.4L7
       5M5.9 6.1v.5h.5M4.2 5v.5h-.8m1
       1.5v.6h-.6m1.2.8L3.6 6.7M5
       8.4l1-.9h.7M4.6 3.6L5 4l.4-.4" />
            </svg>

        </div>
    </div>
</div>
<!-- Preloader End -->

<!-- Header -->
<header class="header-left">

    <!--Logo-->
    <a class="logo" href="#home">
        <img src="${ coordonneesTerra.logoURL }" alt="logo">
    </a>
    
    <!--Hamburger-->
    <a href="javascript:void(0)" class="sidemenu_btn" id="sidemenu_toggle">
        <span></span>
        <span></span>
        <span></span>
    </a>
    <!-- Navigation & Social buttons -->
    <div class="site-nav">

        <!-- Main menu -->
        <ul class="site-main-menu alt-font" id="nav">
            <li><!-- href value = data-id without # of .pt-page. Data-goto is the number of section -->
                <a class="pt-trigger" data-animation="58" data-goto="1" href="#home">
                    <i class="lni-home"></i>
                    <span>Accueil</span>
                </a>
            </li>
            <li>
                <a class="pt-trigger" data-animation="61" data-goto="3" href="#services">
                    <i class="lni-first-aid"></i>
                    <span>Fonctions</span></a>
            </li>
            <li>
                <a class="pt-trigger" data-animation="58" data-goto="5" href="#clients">
                    <i class="lni-emoji-smile"></i>
                    <span>Témoignages</span>
                </a>
            </li>
            <li>
                <a class="pt-trigger" data-animation="59" data-goto="4" href="#portfolio">
                    <i class="lni-gallery"></i>
                    <span>Tarifs</span>
                </a>
            </li>
            <li>
                <a class="pt-trigger" data-animation="61" data-goto="6" href="#contact">
                    <i class="lni-licencse"></i>
                    <span>Contact</span>
                </a>
            </li>
            <li>
                <a class="pt-trigger" data-animation="59" data-goto="2" href="#about">
                    <i class="lni-user"></i>
                    <span>Inscription</span>
                    <span>Connexion</span>
                </a>
            </li>
        </ul>
        <!-- /Main menu -->

    </div>

</header>
<!-- Header End -->

<!-- Site Main -->
<div class="main-left" id="main">

    <!-- Page changer wrapper -->
    <div class="pt-wrapper">
        <!-- Subpages -->
        <div class="subpages">

            <!-- Home -->
            <section id="home" class="pt-page pt-page-1" data-id="home" style="background-color: white; overflow: scroll">
                <div class="portfolio-section ui-block-05" style="margin: auto;">
                    <div class="container" style="padding-bottom: 50px;">
                        <div class="row no-gutters">
                            <div class="col-lg-12 wow fadeInDown" data-wow-delay="400ms">
                                <h5 class="sub-title opacity-6" style="color: #35ab39;">Le terrain dans sa poche avec</h5>
                                <h2 class="title" style="color: #35ab39;">terra La solution prospection</h2>
                                <p class="opacity-6">Gagnez en efficacité avec un logiciel complet, innovant et intuitif.<br>
                                Gérez facilement votre zone de chalandise et boostez vos mandats.</p>
                            </div>
                        </div>
                    </div>
                    <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                        <%
                        int i = 0;
                        String active = "active";
                        for ( SliderBean slider : sliders ) {
                        %>
                            <!-- Item-1 -->
                        
                        	<div class="carousel-item <%= active %>">
                                <img src="<%= slider.getImageURL() %>" alt="image">
                                <div class="col-lg-12 col-sm-12 col-sm-12 button-section">
                                    <h3 style="color: #35ab39;"><%= slider.getTitre() %></h3>
                                    <p class="opacity-6"><%= slider.getDescription() %></p>
                                    <div class="center-button">
                                        <a class="btn button btn-rounded" style="background-color: #35ab39; color: white;" href="<%= slider.getUrlBouton() %>"><%= slider.getTitreBouton() %></a>
                                    </div>
                                </div>
                            </div>
                        <%
                        	active = "";
                        }
						%>
                            <!-- Item-2 
                            <div class="carousel-item">
                                <img src="vendor/img/elements-img/portfolio-img/portfolio-img-5/portfolio-2.jpg" alt="image">
                                <div class="col-lg-12 col-sm-12 col-sm-12 button-section">
                                    <h3 style="color: #35ab39;">Une équipe dédiée à votre réussite</h3>
                                    <p class="opacity-6">Des conseillers réactifs et efficients sont à votre disposition, joignables par e-mail, téléphone ou par chat.</p>
                                    <div class="center-button">
                                        <a class="btn button btn-rounded" style="background-color: #35ab39; color: white;" href="#.">Essai gratuit</a>
                                    </div>
                                </div>
                            </div>
                            -->
                            <!-- Item-3
                            <div class="carousel-item">
                                <img src="vendor/img/elements-img/portfolio-img/portfolio-img-5/portfolio-3.jpg" alt="image">
                                <div class="col-lg-12 col-sm-12 col-sm-12 button-section">
                                    <h3>Vos informations disponibles 24h sur 24</h3>
                                    <p class="opacity-6">Hébergé sur nos serveurs, vous pouvez gérer vos données quand vous le souhaitez.</p>
                                    <div class="center-button">
                                        <a class="btn button btn-rounded white-btn scroll" href="#.">Essai gratuit</a>
                                    </div>
                                </div>
                            </div>
                            -->
                        </div>
                        <!-- Navigation -->
                        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </section>

            <!-- Connexion / Inscription - About -->
            <section id="about" class="pt-page pt-page-2" data-id="about" style="overflow: scroll">
                <div class="container">
                    <div class="row align-items-lg-center">
                        <h1 class="title" style="color: #35ab39; margin-top: 25px; margin-bottom: 50px;">Premier mois offert. Faites un essai !</h1>

                        <!--Inscription area-->
                        <div class="col-lg-6 pr-lg-5" style="box-shadow: 1px 1px 15px #e1e1e1; border-radius: 10px; padding: 45px; right: 40px;">
                            <div class="heading-area">
                                <h6 class="sub-title" style="color: #35ab39;">Merci de bien vouloir vous créer un compte</h6>
                                <h2 class="title">S’inscrire</h2>
                            </div>
                            <!--Contact Form-->
                            <form class="contact-form" id="inscriptionForm" method="post" action="Inscription">
                            <%
							if (session.getAttribute("messageInscriptionValide") != null) {
							%>
								<div class="form-group">
									<div class="alert alert-success text-center" role="alert">
										<%= session.getAttribute("messageInscriptionValide")%>
									</div>
								</div>	
							<%
							}
							%>
							<%
							if (session.getAttribute("messageInscriptionInvalide") != null) {
							%>
								<div class="form-group">
									<div class="alert alert-danger" role="alert">
										<%= session.getAttribute("messageInscriptionInvalide")%>
									</div>
								</div>	
							<%
							}
							%>
                            	<input type="hidden" name="buttonInscription">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <select class="form-select form-select-sm" aria-label=".form-select-sm example"
                                            	name="civiliteInscription" >
                                                <!-- <option selected>Open this select menu</option> -->
                                                <option value="1">Monsieur</option>
                                                <option value="2">Madame</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <!-- <div class="col-sm-12" id="result"></div> -->
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Nom" 
                                            	id="nomInscription" 
                                            	name="nomInscription" required >
                                            <%
											if (session.getAttribute("messageInvalidFirstName") != null) {
											%>
												<div class="form-group">
													<div class="alert alert-danger text-center" role="alert">
														<%= session.getAttribute("messageInvalidFirstName")%>
													</div>
												</div>	
											<%
											}
											%>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Prénom" 
                                            	id="prenomInscription" 
                                            	name="prenomInscription" required >
                                            <%
											if (session.getAttribute("messageInvalidLastName") != null) {
											%>
												<div class="form-group">
													<div class="alert alert-danger text-center" role="alert">
														<%= session.getAttribute("messageInvalidLastName")%>
													</div>
												</div>	
											<%
											}
											%>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <!-- <div class="col-sm-12" id="result"></div> -->
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Téléphone" 
                                            	id="tel" 
                                            	name="telInscription" required>
                                            <%
											if (session.getAttribute("messageInvalidFrenchTel") != null) {
											%>
												<div class="form-group">
													<div class="alert alert-danger text-center" role="alert">
														<%= session.getAttribute("messageInvalidFrenchTel")%>
													</div>
												</div>	
											<%
											}
											%>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Email" 
                                            	id="mailInscription" 
                                            	name="mailInscription" required>
                                            <%
											if (session.getAttribute("messageEmailIsInDatabase") != null) {
											%>
												<div class="form-group">
													<div class="alert alert-danger text-center" role="alert">
														<%= session.getAttribute("messageEmailIsInDatabase")%>
													</div>
												</div>	
											<%
											}
											%>
											<%
											if (session.getAttribute("messageInvalidEmail") != null) {
											%>
												<div class="form-group">
													<div class="alert alert-danger text-center" role="alert">
														<%= session.getAttribute("messageInvalidEmail")%>
													</div>
												</div>	
											<%
											}
											%>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <!-- <div class="col-sm-12" id="result"></div> -->
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Mot de passe" 
                                            	id="passwordInscription" 
                                            	name="passwordInscription" required>
                                            <%
											if (session.getAttribute("messageInvalidPassword") != null) {
											%>
												<div class="form-group">
													<div class="alert alert-danger text-center" role="alert">
														<%= session.getAttribute("messageInvalidPassword")%>
													</div>
												</div>	
											<%
											}
											%>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Confirmez le mot de passe"  
                                            	id="passwordConfirmation" 
                                            	name="passwordConfirmation"required>
                                           	<%
											if (session.getAttribute("messagePasswordNotEqual") != null) {
											%>
												<div class="form-group">
													<div class="alert alert-danger text-center" role="alert">
														<%= session.getAttribute("messagePasswordNotEqual")%>
													</div>
												</div>	
											<%
											}
											%>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <select class="form-select form-select-sm" aria-label=".form-select-sm example"
                                            	name="abonnement">
                                                <!-- <option selected>Open this select menu</option> -->
                                                <option value="10">Abonnement mensuel (20€)</option>
                                                <option value="20">Abonnement annuel (200€)</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                
                                <!--Button-->
                                <a href="#" id="inscriptionButton" class="btn btn-large btn-rounded btn-green d-block mt-4">
                                	<i class="fa fa-spinner fa-spin mr-2 d-none" aria-hidden="true"></i>Inscription</a>

                            </form>
                        </div>

                        <!--Connexion area-->
                        <div class="col-lg-6" style="box-shadow: 1px 1px 15px #e1e1e1; border-radius: 10px; padding: 45px;">
                            <div class="heading-area">
                                <h6 class="sub-title" style="color: #35ab39;">Utilisez vos identifiants pour vous connecter</h6>
                                <h2 class="title">Se connecter</h2>
                            </div>
                            <!--Contact Form-->
                            <form id="connexionForm" class="contact-form" method="post" action="Connexion">
                            <%
							if (session.getAttribute("messageConnexion") != null) {
							%>
								<div class="form-group">
									<div class="alert alert-danger text-center" role="alert">
										<%= session.getAttribute("messageConnexion")%>
									</div>
								</div>	
							<%
							}
							%>
                            	<input type="hidden" name="buttonConnection">
                                <div class="form-group">
                                    <input type="email" placeholder="Email" id="mail" name="mail"
                                    	value="dj.tanguy.paris@gmail.com"> <!-- à retirer en prod -->
                                </div>
                                <div class="form-group">
                                    <input type="password" placeholder="Mot de passe" id="password" name="password"
                                    	value="@@11aaAA"> <!-- à retirer en prod -->
                                </div>
                                <!--Button-->
                                <a href="#" id="connexionButton" class="btn btn-large btn-rounded btn-green d-block mt-4">
                                <!-- le param « contact_btn » dans l’attribut class de <a> déclenche la vérif du form par JS -->
                                	<i class="fa fa-spinner fa-spin mr-2 d-none" aria-hidden="true"></i>Connexion</a>
                            </form>
                            <div style="padding-top: 40px;">
                                <span class="float-right"><span>Mot de passe</span> oublié ?</span>
                            </div>
                        </div>

                    </div>
                </div>
            </section>

            <!-- Fonctionnalités - Services -->
            <section id="services" class="pt-page pt-page-3  lastest-blog" data-id="services"  style="background-color: white; overflow: scroll">
                <!-- <svg class="separator__svg" id="blog-header-svg" width="100%" height="200" viewBox="0 0 100 100" preserveAspectRatio="none" fill="#fff" version="1.1" xmlns="http://www.w3.org/2000/svg">
                    <path d="M 100 100 V 10 L 0 100"/>
                    <path d="M 30 73 L 100 18 V 10 Z" fill="#fff" stroke-width="0"/>
                </svg> -->
                <div class="container position-relative">
                    <div class="row">
                        <div class="col-12 col-md-12 col-lg-6">
                            <div class="blog-content slider-detail wow fadeInDown">
                                <div class="slider-slide">
                                    <h1 class="title" style="color: #35ab39;">METTRE UN SLIDER SUR LA HOME</h1>
                                    <p style="color: #3e3939;">Et ça je le mettrai en dur dans un onglet FONCTIONNALITÉ pour présenter les fonctionnalités de l’appli.</p>
                                    <a href="javascript:void(0);" class="btn btn-large btn-rounded white-tran-yellow-btn">Learn More</a>
                                </div>
                                <div class="slider-slide">
                                    <h1>TERRA</h1>
                                    <h1><span>DESIGN</span> BLOG</h1>
                                    <p>Lorem ipsum is simply dummy text of the printing and typesetting. Lorem Ipsum has been the industry.</p>
                                    <a href="javascript:void(0);" class="btn btn-large btn-rounded white-tran-black-btn">Learn More</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-md-12 col-lg-6">
                            <div class="blog-img wow fadeInUp">
                                <img src="digital-agency/img/blog-mokeup.png">
                                <div class="slider-img">
                                    <div class="img-slide">
                                        <img src="digital-agency/img/blog-mokup-img-2.png" class="mockup-img">
                                    </div>
                                    <div class="img-slide">
                                        <img src="digital-agency/img/blog-mokup-img.png" class="mockup-img">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a class='circle' id="blog-circle-left"><i class="lni lni-chevron-left" style="color: white;"></i></a>
                    <a class='circle' id="blog-circle-right"><i class="lni lni-chevron-right" style="color: white;"></i></a>
                </div>

                <!-- <svg class="separator__svg" id="blog-foot-svg" width="100%" height="200" viewBox="0 0 100 100" preserveAspectRatio="none" fill="#fff" version="1.1" xmlns="http://www.w3.org/2000/svg">
                    <path d="M 100 100 V 10 L 0 100"/>
                    <path d="M 30 73 L 100 18 V 10 Z" fill="#fff" stroke-width="0"/>
                    <img src="digital-agency/img/pot-2.png" alt="plant" class="pot-2 wow slideInLeft" data-wow-delay=".5s">
                </svg> -->
            </section>

            <!-- Tarifs - Portfolio -->
            <section id="portfolio" class="pt-page pt-page-4" data-id="portfolio" style="overflow: scroll">
                <div class="pricing-sec ui-block-05" style="margin: auto;">
                    <div class="container">
                        <div class="row">
                            <div class="pricing-details col-10 offset-1 col-lg-8 offset-lg-2 text-center">
                                <p class="sub-heading"><span></span>Sans engagement de durée.</p>
                                <h4 class="heading">1 mois gratuit<br>sans carte de crédit !</h4>
                                <p class="text">L'abonnement est proposé sans engagement de durée, car nous sommes confiants en notre capacité de répondre à vos besoins spécifiques. En somme, nous misons sur la fidélisation à nos solutions par votre entière satisfaction. L’essayer s’est l’adopter.</p>
                            </div>
                        </div>
                        <div class="row price-cards pb-5 pb-md-0">
                            <div class="pricing-card col-12 col-lg-4 text-center">
                                <h4 class="pricing-card-heading"><%= offre1.getTitreAbonnement() %></h4>
                                <p class="pricing-card-text">Une fois séduit par notre solution, vous pourrez choisir l’abonnement annuel.</p>
                                <h3 class="pricing-amount"><i class="lni-euro"></i><%= offre1.getPrix() %><span>par Mois</span></h3>
                                <ul class="pricing-features">
                                    <li>Carte interactive</li>
                                    <li>Gestion des adresses</li>
                                    <li>Gestion des bâtiments</li>
                                    <li>Gestion des BAL</li>
                                    <li>Gestion des contacts</li>
                                </ul>
                                <a href="#about" class="btn green-trans-btn rounded-pill">C’est parti !
                                    <span></span><span></span><span></span><span></span>
                                </a>
                            </div>
                            <div class="pricing-card active col-12 col-lg-4 text-center wow fadeInUp" data-wow-duration="2s" data-wow-delay=".1s">
                                <h4 class="pricing-card-heading"><%= offre2.getTitreAbonnement() %></h4>
                                <p class="pricing-card-text">Séduit par notre solution ? Abonnez-vous à l’année pour gagner 2 mois offerts.</p>
                                <h3 class="pricing-amount"><i class="lni-euro"></i><%= offre2.getPrix() %><span>par an</span></h3>
                                <ul class="pricing-features">
                                    <li>Carte interactive</li>
                                    <li>Gestion des adresses</li>
                                    <li>Gestion des bâtiments</li>
                                    <li>Gestion des BAL</li>
                                    <li>Gestion des contacts</li>
                                </ul>
                                <a href="#about" class="btn green-trans-btn rounded-pill">C’est parti !
                                    <span></span><span></span><span></span><span></span>
                                </a>
                            </div>
                            <div class="pricing-card col-12 col-lg-4 text-center">
                                <h4 class="pricing-card-heading">Sur-mesure</h4>
                                <p class="pricing-card-text">Vous en avez besoin pour plusieurs collaborateurs, plusieurs agences...</p>
                                <h3 class="pricing-amount">Contactez-nous<span></span></h3>
                                <ul class="pricing-features">
                                    <li>par téléphone au 01 23 45 67 89</li>
                                    <li>ou</li>
                                    <li>par email</li>
                                </ul>
                                <a href="#contact" class="btn green-trans-btn rounded-pill">Contact
                                    <span></span><span></span><span></span><span></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- Livre d’or / Témoignages - Clients -->
            <section id="clients" class="pt-page pt-page-5" data-id="clients" style="overflow: scroll">
                <div class="container">
                        <div class="row d-flex align-content-lg-center min-height-100vh">

                        <!-- Features Box-->
                        <div class="col-lg-4 pr-lg-5 p-0">
                            <div class="heading-area">
                                <h6 class="sub-title" style="color: #35ab39;">CE QUE LEs CLIENTs DIsent DE NOUS</h6>
                                <h2 class="title">ils adorent</h2>
                                <p class="paragraph">De nombreux témoignages sont accessibles sur notre fiche Google My Business, mais également dans la section avis de notre page Facebook.</p>
                            </div>
                            <div id="client-nav"></div>
                        </div>

                        <!-- Client Area-->
                        <div class="col-lg-8">
                            <div id="owl-client" class="owl-carousel owl-theme">
                            <%
                            for ( LivreDOrBean temoignage : temoignages ) {
                            %>                           
                                <!--Items-->
                                <div class="client-box">
                                        <i class="lni-quotation q-icon"></i>
                                        <p><%= temoignage.getCommentaire() %></p>

                                        <div class="client-img">
                                            <img src="<%= temoignage.getPhoto() %>" alt="client">
                                        </div>
                                        <h5 class="client-name mb-0"><%= temoignage.getNom() %></h5>
                                        <span class="client-designation"><%= temoignage.getFonction() %></span>

                                </div>
							<%
                            }
							%>
                                <!--Items
                                <div class="client-box">
                                    <i class="lni-quotation q-icon"></i>
                                    <p>De par sa facilité à configurer notre site, la gestion de la publicité en ligne (Google Ads, Youtube, création de nos bannières pub…), et la simplicité d’utilisation pour nos agents immobiliers (transaction et location), Netty est la solution complète et facile d’utilisation qui nous permet de nous concentrer sur notre quotidien.</p>

                                    <div class="client-img">
                                        <img src="https://www.netty.fr/imgs/avatars/van-haaren-facil-immo.jpg?cache=1657015563" alt="client">
                                    </div>
                                    <h5 class="client-name mb-0">Cyril Van Harren</h5>
                                    <span class="client-designation">Associé et gérant de Facil-Immo.com</span>

                                </div>
                                -->
                                <!--Items
                                <div class="client-box">
                                    <i class="lni-quotation q-icon"></i>
                                    <p>J’ai souscrit un contrat chez eux il y a quelques mois, et sincèrement, je ne trouve rien à redire ! Ils sont souriants, dynamiques, à l’écoute, réactifs, professionnels, ils innovent pour proposer des nouveautés utiles à notre coeur de métier. Et cerise sur le gâteau, (et c’est rare) il n’y a pas d’engagement obligatoire d’un an !</p>

                                    <div class="client-img">
                                        <img src="https://www.netty.fr/imgs/avatars/geist-1789-immobilier.jpg?cache=1657015563" alt="client">
                                    </div>
                                    <h5 class="client-name mb-0">Yannick Geist</h5>
                                    <span class="client-designation">Fondateur de 1789-Immobilier.com</span>

                                </div>
                                -->
                            </div>
                        </div>

                        <!--Partner Slider-->
                        <div class="owl-carousel partners-slider">
                        <%
                        for ( LivreDOrLogosBean logo : logosPartenaires) {
                        %>
                        	<div class="logo-item"> <img alt="client-logo" src="<%= logo.getUrl() %>"></div>
                            <!-- <div class="logo-item"> <img alt="client-logo" src="https://www.netty.fr/imgs/logos/partnerSection/se-loger.png"></div>
                            <div class="logo-item"> <img alt="client-logo" src="https://www.netty.fr/imgs/logos/partnerSection/ilisting.png"></div>
                            <div class="logo-item"> <img alt="client-logo" src="https://www.netty.fr/imgs/logos/partnerSection/scorimmo.png"></div>
                            <div class="logo-item"> <img alt="client-logo" src="https://www.netty.fr/imgs/logos/partnerSection/belles-demeures.png"></div>
                            <div class="logo-item"> <img alt="client-logo" src="https://www.netty.fr/imgs/logos/partnerSection/bien-ici.png"></div>
                            <div class="logo-item"> <img alt="client-logo" src="https://www.netty.fr/imgs/logos/partnerSection/fnaim.png"></div> -->
						<%
						}
						%>
                        </div>

                    </div>
                </div>
            </section>

            <!-- Contacts -->
            <section id="contact" class="pt-page pt-page-6" data-id="contact" style="overflow: scroll">
                <div class="container">
                    <div class="row align-items-lg-center">
                        <div class="col-lg-3">
                        </div>
                        <!--Form area-->
                        <div class="col-lg-6 pr-lg-5">
                            <div class="heading-area">
                                <h6 class="sub-title" style="color: #35ab39;">besoin de renseignements ?</h6>
                                <h2 class="title">Contactez-nous !</h2>
                            </div>
                            <!--Contact Form-->
                            <form class="contact-form" id="contactForm" method="post" action="Contact">
                           	<%
							if (session.getAttribute("messageContactValide") != null) {
							%>
								<div class="form-group">
									<div class="alert alert-success text-center" role="alert">
										<%= session.getAttribute("messageContactValide")%>
									</div>
								</div>	
							<%
							}
							%>
							<%
							if (session.getAttribute("messageContactInvalide") != null) {
							%>
								<div class="form-group">
									<div class="alert alert-danger" role="alert">
										<%= session.getAttribute("messageContactInvalide")%>
									</div>
								</div>	
							<%
							}
							%>
								<!-- AJAX  -->
								<div id="ajaxMessage" class="form-group"></div>
                            	<input type="hidden" name="buttonContact">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <select class="form-select form-select-sm" aria-label=".form-select-sm example"
                                            	name="civiliteContact">
                                                <!-- <option selected>Open this select menu</option> -->
                                                <option value="1">Monsieur</option>
                                                <option value="2">Madame</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <!-- <div class="col-sm-12" id="result"></div> -->
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Nom"  
                                            	id="nomContact" name="nomContact" required>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Prénom" 
                                            	id="prenomContact" name="prenomContact" required>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <!-- <div class="col-sm-12" id="result"></div> -->
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Téléphone" 
                                            	id="telContact" name="telContact" required>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Email" 
                                            	id="mailContact" name="mailContact" required>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Objet / Sujet" 
                                    	id="objetContact" name="objetContact" required>
                                </div>

                                <div class="form-group">
                                    <textarea class="form-control" placeholder="Message" 
                                    	id="messageContact" name="messageContact"></textarea>
                                </div>

                                    <!--Button-->
                                <a href="#" id="contactButton" class="btn btn-large btn-rounded btn-green d-block mt-4">
                                	<i class="fa fa-spinner fa-spin mr-2 d-none" aria-hidden="true"></i>Envoyer la demande</a>

                                </form>

                                <!-- Address -->
                                <ul class="address-item">
                                   <!--item-->
                                   <li class="w-100 mb-4">
                                       <i class="lni-apartment" style="color: #35ab39;"></i>
                                       <div class="content">
                                           <h6 class="m-0" style="color: #35ab39;">Adresse</h6>
                                           <p>${ coordonneesTerra.adresse }.</p>
                                       </div>
                                   </li>
                                    <!--item-->
                                    <li class="pr-2">
                                        <i class="lni-comment-reply" style="color: #35ab39;"></i>
                                        <div class="content">
                                           <h6 class="m-0" style="color: #35ab39;">Email:</h6>
                                           <p><a href="mailto:${ coordonneesTerra.mail }">${ coordonneesTerra.mail }</a></p>
                                       </div>
                                    </li>
                                    <!--item-->
                                    <li>
                                        <i class="lni-phone-handset" style="color: #35ab39;"></i>
                                        <div class="content">
                                           <h6 class="m-0" style="color: #35ab39;">Téléphone :</h6>
                                           <p><a href="tel:${ coordonneesTerra.tel }">${ coordonneesTerra.tel }</a></p>
                                       </div>
                                    </li>

                                </ul>

                        </div>

                        <!--map area-->
                        <!-- 
                        <div class="col-lg-6">
                            <div class="map-half bg-map" id="map"></div>
                        </div>
                         -->
                    </div>
                </div>
            </section>

        </div>
        <!-- End of Home Subpage -->

    </div>

</div>
<!-- Site Main End -->


<!-- JavaScript -->
<script src="vendor/js/bundle.min.js"></script>
<!-- Plugin Js -->
<script src="vendor/js/jquery.appear.js"></script>
<script src="vendor/js/jquery.fancybox.min.js"></script>
<script src="vendor/js/owl.carousel.min.js"></script>
<script src="vendor/js/parallaxie.min.js"></script>
<script src="vendor/js/wow.min.js"></script>
<script src="vendor/js/TweenMax.min.js"></script>
<script src="vendor/js/jquery.cubeportfolio.min.js"></script>
<script src="vendor/js/wow.min.js"></script>

<!-- REVOLUTION JS FILES -->
<script src="vendor/js/jquery.themepunch.tools.min.js"></script>
<script src="vendor/js/jquery.themepunch.revolution.min.js"></script>
<!-- SLIDER REVOLUTION EXTENSIONS -->
<script src="vendor/js/extensions/revolution.extension.actions.min.js"></script>
<script src="vendor/js/extensions/revolution.extension.carousel.min.js"></script>
<script src="vendor/js/extensions/revolution.extension.kenburn.min.js"></script>
<script src="vendor/js/extensions/revolution.extension.layeranimation.min.js"></script>
<script src="vendor/js/extensions/revolution.extension.migration.min.js"></script>
<script src="vendor/js/extensions/revolution.extension.navigation.min.js"></script>
<script src="vendor/js/extensions/revolution.extension.parallax.min.js"></script>
<script src="vendor/js/extensions/revolution.extension.slideanims.min.js"></script>
<script src="vendor/js/extensions/revolution.extension.video.min.js"></script>
<!-- google map -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCJRG4KqGVNvAPY4UcVDLcLNXMXk2ktNfY"></script>
<script src="personal/js/map.js"></script>
<!-- custom script -->
<script src="digital-agency/js/slick.min.js"></script>
<script src="personal/js/page-transition.js"></script>
<script src="vendor/js/contact_us.js"></script>
<script src="personal/js/script.js"></script>
<script src="digital-agency/js/script.js"></script>
<!-- Start ui-block-05 -->
<script>
    $('.ui-block-05.pricing-sec .pricing-card').on('mouseover',function () {
        $('.ui-block-05.pricing-sec .pricing-card:nth-child(2)').removeClass('active');
    });
    $('.ui-block-05.pricing-sec .pricing-card').on('mouseleave',function () {
        $('.ui-block-05.pricing-sec .pricing-card:nth-child(2)').addClass('active');
    });
</script>
<script type="text/javascript">
	document.getElementById("connexionButton").onclick = function() {
		document.getElementById("connexionForm").submit();
	}
	document.getElementById("inscriptionButton").onclick = function() {
		document.getElementById("inscriptionForm").submit();
	}
	document.getElementById("contactButton").onclick = function() {
		document.getElementById("contactForm").submit();
	}
</script>
<!-- AJAX -->
<script type="text/javascript">
	
   	/* $(document).ready( function( event ) { */
   		
   		// EN JS
    	/* var xhr = new XMLHttpRequest();
    	xhr.onload = function() {
    		var message = JSON.parse( this.responseText );
			console.log( message ); */ /* this.responseText */
			/* document.getElementById( "ajaxMessage" ).innerHTML = message.corps;
		}
   		
    	xhr.open( "get", "rest/contact/get/6", true );
    	xhr.send(); */
    	
    	// EN JQuerry
    	/* $.ajax( {
    		url : "rest/contact/get/6?ts=" + new Date().getTime(), */ /* éviter le cache grâce à une URL unique */
    		/* dataType: "json",
    		success: function( message ) {
    			$("#ajaxMessage").text( message.corps + " !!!");
    		}
    	} );
   	}); */
   	
	// EN JQuerry
	/* var idMessage = 0;
   	
   	function loadMessage() {
    	$.ajax( {
    		url : "rest/contact/get/" + idMessage + "?ts=" + new Date().getTime(), // éviter le cache grâce à une URL unique
    		dataType: "json",
    		success: function( contact ) {
		    	console.log( contact );
    			$("#ajaxMessage").text('<div class="alert alert-success" role="alert">' 
    					+ contact.nom + " souhaite des infos sur " + contact.objet + "</div>");
    		}
    	} );
	}
   	
   	$(document).ready( function( event ) {   		
   		$("#contactButton").click( function( event ) {   			
   			if ( ++idMessage > 4 ) idMessage = 1;
   			
	   		console.log( idMessage );
		   	loadMessage();
   		} );
   	} ); */
</script>
</body>
</html>