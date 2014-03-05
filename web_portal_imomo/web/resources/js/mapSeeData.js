/**
 * Cette fonction recoit le status d'ajax en paramètre.
 * Si le status est un succès, la résultat de la requete assynchrone (en format JSON) est parsée.
 * L'affichage se fait à l'aide d'un tableau.
 * @returns {undefined}
 */
function mapAjaxSuccessStatus()
{
    var outputInfo = document.getElementById("outputInfo");
    var info = outputInfo.innerHTML;
    if (info !== "" && info !== null)
    {
        /*
         * @type @exp;JSON@call;parse
         * [ [map info],  [ [variableName, [ [date, [user, value]], ... ] ] ] ]
         */
        var infoParsed = JSON.parse(info);

        //Affichage des informations concernant le site
        displayInfoSite(infoParsed[0]);

        //Récupération d'un tableau contenant toutes les valeurs et leurs date pour chaque nom de variable
        var mainTab = getTabVariableNameData(infoParsed);

        //On enlève les graphes pour en ajouter des nouveau par la suite
        deleteChildren(document.getElementById('visualization'));

        createChart(mainTab);
    }
}

/**
 * Création des graphes en récupérant les informations dans un tableau.
 * Le tableau contient un autre tableau contenant en première case le nom de la variable.
 * En deuxième case, un autre tableau contenant la date et la valeur.
 * 
 * @param {type} mainTab
 * @returns {undefined}
 */
function createChart(mainTab)
{
    var tabDataTable = new Array();
    var tabAnnotatedTimeLine = new Array();
    for (var iVariableName = 0; iVariableName < mainTab.length; ++iVariableName)
    {
        tabDataTable[iVariableName] = new google.visualization.DataTable();
        tabDataTable[iVariableName].addColumn('date', 'Date');
        tabDataTable[iVariableName].addColumn('number', mainTab[iVariableName][0]);
        tabDataTable[iVariableName].addColumn('string', 'User');

        tabDataTable[iVariableName].addRows(mainTab[iVariableName][1].length);
        for (var iValue = 0; iValue < mainTab[iVariableName][1].length; ++iValue)
        {
            //on récupère la date
            tabDataTable[iVariableName].setCell(iValue, 0, mainTab[iVariableName][1][iValue][0]);

            //la valeur
            tabDataTable[iVariableName].setCell(iValue, 1, parseFloat(mainTab[iVariableName][1][iValue][1]));

            //le user
            tabDataTable[iVariableName].setCell(iValue, 2, mainTab[iVariableName][1][iValue][2]);
        }

        //Pour chaque graphe, on crée un div pour le contenir
        var iDiv = document.createElement('div');
        iDiv.id = "visualization" + iVariableName;
        iDiv.className = 'cacacaca';
        iDiv.style.width = "450px";
        iDiv.style.height = "250px";
        iDiv.style.display = "inline-block";
        document.getElementById('visualization').appendChild(iDiv);
        tabAnnotatedTimeLine[iVariableName] = new google.visualization.AnnotatedTimeLine(
                document.getElementById(iDiv.id));
        tabAnnotatedTimeLine[iVariableName].draw(tabDataTable[iVariableName], {'displayAnnotations': true});
    }
}

function deleteChildren(parent)
{
    while (parent.hasChildNodes()) {
        parent.removeChild(parent.lastChild);
    }
}

function getTabVariableNameData(infoParsed)
{
    /*
     * mainTab
     * @type Array
     *
     * [ [variableName, [ [ date, value, user ], [ ... ] ] ], [ ... ] ]
     * 
     * mainTab[i] => [variableName, [ [ date, value, user ], [ ... ] ] ]
     * mainTab[i][0] => variableName
     * mainTab[i][1] => [ [ date, value, user ], [ ... ] ]
     * mainTab[i][1][0] => [ date, value, user ]
     * mainTab[i][1][0][0] => date
     * mainTab[i][1][0][1] => value
     */
    var mainTab = new Array();

    //Récupération dans mainTab de toutes les données se trouvant dans la variable parsée.
    for (var variableName in infoParsed[1])
    {
        var tabAllDataValue = new Array();
        var tabVariableDateValue = new Array();
        tabVariableDateValue.push(variableName);
        tabVariableDateValue.push(tabAllDataValue);

        //On récupère ici la date et la valeur
        for (var msDate in infoParsed[1][variableName])
        {
            var tabDataValue = new Array();
            tabDataValue.push(new Date(parseInt(msDate)));

            //Récupération de la valeur
            tabDataValue.push(infoParsed[1][variableName][msDate][1]); //la valeur
            tabDataValue.push(infoParsed[1][variableName][msDate][0]); //le user
            tabAllDataValue.push(tabDataValue);
        }
        mainTab.push(tabVariableDateValue);
    }

    return mainTab;
}

function displayInfoSite(infoParsed)
{
    var tableInfo = document.getElementById("tableInfoBody");
    var strInfoSite = "";
    for (var key in infoParsed)
    {
        strInfoSite += "<tr class='tableInfoLine'>";
        strInfoSite += "<td class='tableInfoValue'>" + infoParsed[key] + "</td>";
        strInfoSite += "</tr>";
    }

    tableInfo.innerHTML = strInfoSite;
}