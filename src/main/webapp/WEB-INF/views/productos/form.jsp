<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroProducto">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Producto</title>

		<script type="text/javascript" src="/springtaller/resources/angular/angular.js"></script>

   <!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="/springtaller/resources/materialize/css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


<script type="text/javascript">

// declaramos el modulo principal
angular.module("registroProducto",[]);
//accedemos al modulo
																	   //intermediario						
angular.module("registroProducto").controller("productoController",function($scope,$http){ 
	
	
$scope.aplicativo="Registro de Producto";
	
	
$scope.registrarProducto=function(producto){
	
$http.post("http://localhost:8080/springtaller/producto",producto).success(function(){

	delete $scope.producto;
	
	cargarProductos();
	
	
});
	
};//fin registroProducto


var cargarProductos=function(){
	
	
$http.get("http://localhost:8080/springtaller/producto").success(function(productos){  
	
	$scope.productos=productos;
	
});	
	
};
	
	
	cargarProductos();
	
});









</script>




</head>
<body ng-controller="productoController">


<h2 ng-bind="aplicativo"></h2>


<div class="row">

	<div class="col s2"></div>

	{{producto}}	 
		
    <form class="col s8">
    
    <div class="card-panel">
      <div class="row">
        <div class="input-field col s6">
<!--           <i class="material-icons prefix">account_circle</i> -->
          <input id="descripcion" type="text" class="validate" ng-model="producto.descripcion">
          <label for="descripcion">Descripcion</label>
        </div>
        
        <div class="input-field col s6">
			<i class="material-icons prefix">today</i>
			
          <input id="fecha" type="date" class="datepicker" ng-model="producto.fechaVencimiento">
          <label for="fecha">Fecha de Vencimiento</label>
        </div>
        
        <div class="input-field col s6">
<!--           <i class="material-icons prefix">phone</i> -->
          <input id="precio" type="number" class="validate" ng-model="producto.precio">
          <label for="precio">Precio</label>
        </div>
        <div class="input-field col s6">
<!--           <i class="material-icons prefix">phone</i> -->
          <input id="cantidad" type="number" class="validate" ng-model="producto.cantidad">
          <label for="cantidad">Cantidad</label>
        </div>
        
        
        
      </div>
      
      </div>
      
    <button ng-click="registrarProducto(producto)" class="btn waves-effect waves-light" type="submit" name="action">Registrar
    <i class="material-icons right">save</i>
  </button>
      
      
    </form>
    
    
    <div class="col s2"></div>
  </div>
  
  
  
  
<div class="row">

<div class="col s12">

<table class="responsive-table highlight">

<thead>
<tr>
<th>Descripcion</th>
<th>Fecha de Vencimiento</th>
<th>Precio</th>
<th>Cantidad</th>
</tr>

</thead>


<tbody>

</tbody>

<tr ng-repeat="producto in productos">
<td>{{producto.descripcion}}</td>
<td>{{producto.fechaVencimiento}}</td>
<td>{{producto.precio}}</td>
<td>{{producto.cantidad}}</td>
</tr>
</table>




</div>



</div>






  <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="/springtaller/resources/materialize/js/materialize.min.js"></script>



<script type="text/javascript">


	$(document).ready(function() {
    
		$('.datepicker').pickadate();
	
     });

</script>


</body>
</html>