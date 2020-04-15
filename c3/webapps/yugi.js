
function addText() {
    //getting text values for all user entered information and storing in vars
    //has to be done on button click or else wouldnt have updated data :^)
    var cardtype = document.getElementById("select").value;
    var atk = document.getElementById("attack").value;
    var def = document.getElementById("defense").value;
    var name = document.getElementById("name").value;
    var desc = document.getElementById("desc").value;
    var type = document.getElementById("monType").value;

    
    document.getElementById("cardpic").src="/c3/webapps/resources/yugiohTemplates/" + cardtype.toLowerCase() + ".png";
    //combining atkdef into one value for easier formatting
    var atkDef = "<hr />ATK/" + atk + " DEF/" + def;
    
    
    //adding text on button press to P elements
    document.getElementById("atkDef").innerHTML = atkDef;
    document.getElementById("cardName").innerHTML = name;
    document.getElementById("typeText").innerHTML = "[" + type + "]";
    document.getElementById("cardDesc").innerHTML = desc;
    
    
}

//showing image on card
  function showMyImage(fileInput) {
        var files = fileInput.files;
        for (var i = 0; i < files.length; i++) {           
            var file = files[i];
            var imageType = /image.*/;     
            if (!file.type.match(imageType)) {
                continue;
            }           
            var img=document.getElementById("thumbnil");            
            img.file = file;    
            var reader = new FileReader();
            reader.onload = (function(aImg) { 
                return function(e) { 
                    aImg.src = e.target.result; 
                }; 
            })(img);
            reader.readAsDataURL(file);
        }    
    }