<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Advocacia LCA - Listar Processos</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="components/menu.jsp"></c:import>
		<section class="container">
			<ol class="breadcrumb">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">Processo</a></li>
				<li class="active">Listar Processos</li>
			</ol>
			<article>
			<p class="bg-success text-success"><c:out value="${sucesso}"></c:out></p>
				<div class="panel panel-default">
					<div class="panel-body">
						<form class="form-horizontal" role="form" method="get"
							action="Filtro">
							<div class="form-group">
								<label for="numeroProcesso" class="col-sm-2 control-label">Número
									do Processo:</label>
								<div class="col-md-7">
									<input type="text" class="form-control" id="numeroProcesso"
										name="numeroProcesso" placeholder="Ex.: 9.999.999.999">
								</div>
							</div>
							<div class="form-group">
								<label for="nomeCliente" class="col-sm-2 control-label">Nome
									do Cliente:</label>
								<div class="col-md-7">
									<input type="text" class="form-control" id="nomeCliente"
										name="nomeCliente" placeholder="Ex.: João Maria José">
								</div>
							</div>
							<div class="form-group">
								<label for="inicio" class="col-sm-2 control-label">Período:</label>
								<div class="col-md-3">
									<input type="date" class="form-control" id="inicio"
										name="deData">
								</div>
								<label for="ate" class="col-sm-1 control-label text-left">até:</label>
								<div class="col-md-3">
									<input type="date" class="form-control" id="ate" name="ateData">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-search"></span> Buscar
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</article>
			<article>
				<div class="panel panel-default">
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Número</th>
									<th>Descrição</th>
									<th>Cliente</th>
									<th>Ação</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listaProcessos}" var="listagem">
									<tr>
										<td>${listagem.numeroProcesso}</td>
										<td>${listagem.descricao}</td>
										<td>${listagem.cliente.razaoSocial}</td>
										<td>
											<div class="btn-group">
												<button type="button"
													class="btn btn-info btn-xs dropdown-toggle"
													data-toggle="dropdown">
													Despesa <span class="caret"></span>
												</button>
												<ul class="dropdown-menu">
													<li><a
														href="NovaDespesa?numeroProcesso=${listagem.numeroProcesso}&cliente=${listagem.cliente.razaoSocial}"><span
															class="glyphicon glyphicon-plus"></span> Lançar Despesa</a></li>
													<li class="divider"></li>
													<li><a
														href="ListaDespesa?numeroProcesso=${listagem.numeroProcesso}&cliente=${listagem.cliente.razaoSocial}"><span
															class="glyphicon glyphicon-search"></span> Consultar
															Despesas</a></li>
												</ul>
											</div>
											<div class="btn-group">
												<button type="button"
													class="btn btn-primary btn-xs dropdown-toggle"
													data-toggle="dropdown">
													Honorário <span class="caret"></span>
												</button>
												<ul class="dropdown-menu">
													<li><a
														href="NovoHonorario?numeroProcesso=${listagem.numeroProcesso}&cliente=${listagem.cliente.razaoSocial}"><span
															class="glyphicon glyphicon-plus"></span> Lançar Honorário</a></li>
													<li class="divider"></li>
													<li><a
														href="ListaHonorario?numeroProcesso=${listagem.numeroProcesso}&cliente=${listagem.cliente.razaoSocial}"><span
															class="glyphicon glyphicon-search"></span> Consultar
															Honorários</a></li>
												</ul>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</article>
		</section>
		<footer class="container">
			<div class="well well-sm">
				<small class="text-info">Advocacia LCA&reg; Todos os direitos
					reservados.</small>
			</div>
		</footer>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>
