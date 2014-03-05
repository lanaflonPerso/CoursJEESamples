

window.onload = function()
{
    var regexp = /MSIE (\d+\.\d+);/;
    var language = "";
    if (regexp.test(navigator.userAgent))
    {
        var ieversion = new Number(RegExp.$1);
        if (9 > ieversion)
        {
            if (navigator.browserLanguage)
            {
                language = navigator.browserLanguage;
            }
            else
            {
                language = navigator.language;
            }
            var strAppInfo = navigator.appName.toString() + navigator.appVersion.toString();
            var strLinkValue = "";
            var strMainMsg = "";
            if (language.indexOf('fr') > -1)
            {
                strMainMsg = "Pour une meilleure utilisation de ce site, nous vous conseillons de mettre à jour votre navigateur";
                strLinkValue = "Liste de navigateurs pouvant être installés";
            }
            else
            {
                strMainMsg = "For a best use of this website an update of the navigator is recommanded";
                strLinkValue = "List of navigators whom can to be installed";
            }
            var strLink = "<a href='http://download.cnet.com/windows/web-browsers/'>" + strLinkValue + "</a>";
            var strFinalMsg = "<p>" + strAppInfo + "</p>" + "<p>" + strMainMsg + "</p>" + "<p>" + strLink + "</p>";
            document.getElementById("divMsgOldNavigator").innerHTML = strFinalMsg;
        }
    }
};