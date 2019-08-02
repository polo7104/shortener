<%@ page import="java.net.InetAddress" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <head>
        <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css" />
        <script src="/static/js/jquery/jquery.min.js" ></script>
        <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    </head>

<%
    String ipAddress=request.getRemoteAddr();
    if(ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
        InetAddress inetAddress= InetAddress.getLocalHost();
        ipAddress=inetAddress.getHostAddress();
    }
%>
    <body>
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-auto" style="margin-top: 100px">
                    <div class="input-group mb-3">
                        <input id="ori_url" type="text" class="form-control" placeholder="Shorten URL" aria-label="Shorten URL" aria-describedby="btn_submit">
                        <div class="input-group-append">
                            <button class="btn btn-danger" type="button" id="btn_submit">GET</button>
                            <button class="btn btn-success" type="button" id="btn_history">Show History</button>
                        </div>
                    </div>
                    <div id="result">
                    </div>
                    <div id="history">

                    </div>

                </div>
            </div>
        </div>


    <script>
        $(document).on('click','#btn_submit',function(e){
            var urlValidation = $('#ori_url').val().match(/(http(s)?:\/\/.)?(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)/g);
            if(urlValidation == null){
                alert('Check please url');
                return;
            }else{
                $.post('/put/url',{url:$('#ori_url').val()},function(data){
                    if(data == "0"){ //insert error
                        alert('Sorry error occurred for your request');
                    }else{
                        $('#result').html('<a href="javascript:goThruShorten(\''+data+'\')">'+window.location.href+data+'</a>');
                    }
                })
            }
        })

        const goThruShorten = function(id){

            var form = document.createElement("form");

            form.setAttribute("charset", "UTF-8");
            form.setAttribute("method", "Post");  //Post
            form.setAttribute("target", "_blank");
            form.setAttribute("action", "/put/urlHit"); //url

            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", "url");
            hiddenField.setAttribute("value", window.location.href+id);
            form.appendChild(hiddenField);
            hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", "ip");
            hiddenField.setAttribute("value", '<%=ipAddress%>');
            form.appendChild(hiddenField);

            document.body.appendChild(form);

            form.submit();

            window.open('/put/urlHit');
        }

        $(document).on('click','#btn_history',function(data){
            $.get('/get/history',function(data){
                $('#history').html(data);
            })
        })
    </script>
    </body>




</html>