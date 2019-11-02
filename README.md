## ASSISTANTE VIRTUELLE
**Project name:** **L**ocal **I**ntelligent **S**ystem **A**gent

#### Ireto daholo no hita ato aminíty prototype ity:

 - Reconnaissance vocale avec JSAPI Cloudgarden
- Chatbot avec Programm-AB et le langage AIML
- Synthese vocale avec SIVOX

#### REQUIREMENTS:

- Windows 7/8/8.1
- Jdk 8 32bits (tsy mety mande 64bit le jsapi)
- Netbeans: Projet natao tam netbeans io de mclone fotsiny de mety

#### CONFIGURATION RECONNAISSANCE VOCALE WINDOWS 7:

- Rechercher dans menu demmarrer Reconnaissance vocale cliquer sur reconnaissance vocale de windows puis suivant suivant ...
- Ataovy mande tsara ny micro
- Puis rechercher synthese vocale et cliquer sur modifier les parametres du syntheses vocales
- Cliquer sur l'onglet reconaissance vocale et creer un profil
- Faire un apprentissage pour avoir de la precision

#### HOW TO GET PROJECT?

1) Midira ao amin'ny dossier misy ny projet netbeans: C:\Users\...\Documents\NetBeansProjects
2) Cloner le projet sur github: taper sur la ligne de commande.

```shell
git clone https://github.com/andryravalimanana/lisa.git
```


3) Midira ao anaty le projet lisa. misy dossier lib ao.
4) Copier C:\Users\...\Documents\NetBeansProjects\lisa\lib\cgjsapi170.dll dans C:\Program Files (x86)\Java\jdk1.8.0_31\bin
5) Rehefa vita zay de lanceo fa tokony mande

#### ARCHITECTURE DU PROJETS:

##### 1) RECONNAISSANCE VOCALE

Zavatra 1 ihany no tena important ao. 
Ny fichier grammaire C:\Users\...\Documents\NetBeansProjects\jsapi\src\rsc\grammar\jsapi.jsgf
Manoratra grammaire raha tiana ho preci ny reconnaissace vocale. 

Efa misy exemple vitsivitsy basique ao fa ra hanoratra grammaire complexe kokoa de jerevo ato: https://www.w3.org/TR/2000/NOTE-jsgf-20000605/



##### 2) SYNTHESE VOCALE

Ny synthese vocale ao de ny SIVOX Mbrola.
Afaka maka Voix hafa Mbrola de apesao ze mety: http://tcts.fpms.ac.be/synthesis/

1. Rehefa azo de copieo ao amin'ny donnes mbrola ao @ project => donnees/Mbrola/fr4 (mamorona dossier mitovy am io fr1 io, ohatra eto zao fr4)
2. Configurena ao @ si_vox.conf ny voix tiana apesaina, ohatra ny eto le fr4 de soloina fr4 le ao.



##### 3) CHAT BOT

Ny chat bot de soratana @ langage AIML. Ny toerana misy ny connaissance rehetra de ato C:\Users\...\Documents\NetBeansProjects\jsapi\src\rsc\bots\lisa\aiml
Efa misy exemple vitsivitsy ko ao fa raha hijery misimisy kokoa de jereo ny doc officiel: http://callmom.pandorabots.com/static/reference/



#### TEST:

Ireto no teste efa misy ao ka nandramako de nandeha tsara.

1. Bonjour
2. Bonjour Lisa
3. Comment va tu?
4. Comment t'appelle tu?
5. Allume la lumiere
6. Active le ventillateur
