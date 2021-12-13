$(document).ready(function(){
    $('#btn1').on('click', function(){
        var form = {
            name: "jamong",
            age: 23
        }
        $.ajax({
            url: "requestObject",
            type: "POST",
            data: form,
            success: function(data){
                $('#result').text(data);
            },
                error: function(){
                alert("simpleWithObject err");
            }
        });
    });

    $('#btn2').on('click', function(){
        $.ajax({
            url: "requestObject/serialize",
            type: "POST",
            data:
                $("#frm").serialize(),
            success: function(data){
                $('#result').text(data);
            },
            error: function(){
                alert("serialize err");
            }
        });
    });
});