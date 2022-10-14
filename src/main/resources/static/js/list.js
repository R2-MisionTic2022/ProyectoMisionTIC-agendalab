
var editando = false;

function transformarEnEditable(nodo) {

    //El nodo recibido es SPAN

    if (editando == false) {

        var nodoTd = nodo.parentNode; 
        var nodoTr = nodoTd.parentNode; 

        var nodosEnTr = nodoTr.getElementsByTagName('td');

        var cups = nodosEnTr[0].textContent; 
        var examen = nodosEnTr[1].textContent;
        var seccion = nodosEnTr[2].textContent; 
        var valor = nodosEnTr[3].textContent;
        var descripcion = nodosEnTr[4].textContent; 
        

        var nuevoCodigoHtml = '<td><input form="formul" type="text" name="cups" id="cups" value="' + cups + '" size="5" readonly></td>' +
                              '<td><input form="formul" type="text" name="examen" id="examen" value="' + examen + '" size="15"></td>' +
                              '<td><input form="formul" type="text" name="seccion" id="seccion" value="' + seccion + '" size="15"></td>' +
                              '<td><input form="formul" type="text" name="valor" id="valor" value="' + valor + '" size="10"></td>' +
                              '<td><textarea form="formul" type="text" name="descripcion" id="descripcion" rows="2" cols="70">'+ descripcion +'</textarea></td>' +
                              '<td>' + 
                                 '<form id="formul" name = "formulario" action="/adminEditar" method="post">' +
                                     '<input class="boton" type = "submit" value="Aceptar">'+ 
                                     '<input class="boton" type="reset" value="Cancelar" onclick="anular()">'+
                                 '</form>'
                              '</td>';

        nodoTr.innerHTML = nuevoCodigoHtml;
        editando = "true";
    }
    else {
        alert('Solo se puede editar una línea. Recargue la página para poder editar otra');
    }
}

function anular() {

    window.location.href = "/adminlist";

}

function eliminar(nodo){ 
    var nodoTd = nodo.parentNode; 
        var nodoTr = nodoTd.parentNode; 

        var nodosEnTr = nodoTr.getElementsByTagName('td');

        var cups = nodosEnTr[0].textContent;

        console.log(cups);
    
        swal({
            title: "¿Está seguro de eliminar?",
            text: "Una vez eliminado, no podrá ser recuperado",
            icon: "warning",
            buttons: true,
            dangerMode: true,
         })
          .then((OK) => {
            if (OK) {
                $.ajax({
                    url:"/eliminar/"+cups,
                    success: function(res){
                    console.log(res);
                    }
                });
              swal("Su examen ha sido eliminado", {
                icon: "success",
            }).then((OK) => {
                if(OK) {
                    location.href="/adminlist";
                }
            });
            } else {
              swal("Su examen esta seguro");
            }
          });
    
        }




