
function addText() {
    //getting text values for all user entered information and storing in vars
    //has to be done on button click or else wouldnt have updated data :^)
    var type = document.getElementById("select").value;
    var HP = document.getElementById("HP").value;
    var name = document.getElementById("name").value;
    var abil1 = document.getElementById("abil1").value;
    var abilDesc1 = document.getElementById("abilDesc1").value;
    var abil2 = document.getElementById("abil2").value;
    var abilDesc2 = document.getElementById("abilDesc2").value;
    var weakness = document.getElementById("weakness").value;
    var resist = document.getElementById("resist").value;
    var retreat = document.getElementById("retreat").value;
    var etc = document.getElementById("extra").value;
    
    //adding text on button press to P elements
    document.getElementById("cardHP").innerHTML = HP + "HP";
    document.getElementById("cardName").innerHTML = name;
    document.getElementById("a1").innerHTML = abil1;
    document.getElementById("adesc1").innerHTML = abilDesc1 + "<hr />";
    document.getElementById("a2").innerHTML = abil2;
    document.getElementById("adesc2").innerHTML = abilDesc2 + "<hr />";
    document.getElementById("weak").innerHTML = weakness;
    document.getElementById("resis").innerHTML = resist;
    document.getElementById("retr").innerHTML = retreat;
    document.getElementById("etc").innerHTML = etc;
    
    document.getElementById("cardtype").src="images/" + type + ".png";
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