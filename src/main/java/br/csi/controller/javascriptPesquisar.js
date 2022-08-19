$(function(){
    $('#pesquisa').keyup(function(){
        var pesquisa = $(this).val();
        if(pesquisa!=''){
            var dados= {
                palavra : pesquisa
            }
            $.post('busca.php',dados,function(retorna){
                $('.rPesquisa').html(retorna);
            });
        }else{
            var dados = {
                palavra : "pesquisa"
            }
            $.post('busca.php',dados,function(retorna){
                $('.rPesquisa').html(retorna);
            });
        }
    });

});