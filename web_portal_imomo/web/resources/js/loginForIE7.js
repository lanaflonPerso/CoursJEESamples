/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {
    var buttonDialog = document.getElementById("formMenuBar:loginLink");
    var formLogin = document.getElementById("divLoginForIE7");
    if (Function('/*@cc_on return document.documentMode===7@*/')()) {
        buttonDialog.style.display = "none";
        formLogin.style.display = "inline-block";
    }
});