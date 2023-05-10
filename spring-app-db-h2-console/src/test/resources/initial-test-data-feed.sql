INSERT INTO feed (id, external_id, title, type, description, category, priority, status, resolution, assigned_group, submit_timestamp, close_timestamp, company, organization, source, eingabe_timestamp, eingabe_user, mutation_timestamp, mutation_user, version)
VALUES (103, 'inc000000152156', 'F: ISS: Nur ein Gesprächsteilnehmer hörbar', null, '1. Incident Informationen erhalten:

   Login:  zh58668o
   Name: Nachname & Vorname:
   Targetnummer: 201810032579360
   Gesprächs ID: 1000056633772
   Phone: Bitte Direktetnummern verlangen: 079 955 23 56
   E-Mail Bitte immer verlangen & kontrollieren dupa@kapo.zh.ch

   Nur ein Gesprächsteilnehmer hörbar


2. Analysieren des Anrufes.
    Nach einem Handover (GSM -> GSM) ist nur noch ein Kanal
    hörbar. Da die Daten für einen Kanal nicht ausgeleitet werden,
    kann das Gespräch nicht wieder hergestellt werden. Der
    Fehler lässt sich auch nicht reproduzieren.


3. Da das problem nicht reproduziert werden kann -->
    Ticket schliessen. Kunde informiert.', 'ISS (Interception System Schweiz)', 'Low', 'Closed', 'Nach einem Handover (GSM -> GSM) ist nur noch ein Kanal
    hörbar. Da die Daten für einen Kanal nicht ausgeleitet werden,
    kann das Gespräch nicht wieder hergestellt werden. Der
    Fehler lässt sich auch nicht reproduzieren.',
        'ÜPF-ISS', '2018-11-05 15:50:55', '2018-11-12 02:00:52', 'KAPO', 'ZH', 'REMEDY', '2019-02-26 14:02:16.287000', '83005417', '2019-02-26 14:02:16.287000', '83005417', 1);

INSERT INTO feed (id, external_id, title, type, description, category, priority, status, resolution, assigned_group, submit_timestamp, close_timestamp, company, organization, source, eingabe_timestamp, eingabe_user, mutation_timestamp, mutation_user, version)
VALUES (104, 'inc000000152081', 'S: ISS: Abbruch eines Gesprächs', null, '1. Incident Informationen erhalten:

     Sehr geehrte Damen und Herren

     Bei der Linie LIID 201802082460910 ist beim Produkt
     1000040960272 (und bei den dazugehörigen Produkten) der
     Gesprächsanfang zu hören und als der Anrufer eine weitere
     Nummer (Konferenz) zuschaltet, bricht das Gespräch ab.
     Dieses Konferenzgespräch ist im ISS nicht wieder auffindbar.
     Gibt es dazu eine technische Erklärung?
     Ich bitte um Kontaktaufnahme.

     Der Support wird gebeten und ermächtigt die entsprechenden
     Produkte zu analysieren.
     Besten Dank im Voraus.

     Freundliche Grüsse
     Ueli Rüsch

2.  Analysieren des Anrufes. Sobald die Konferenzschaltung
     aktiviert wird, wird die Ausleitung des Anrufes beendet.
     Nach dem Abbruch ist keine weitere Kommunikation mehr
     vorhanden (wird nicht ausgeleitet).

3.  Kunde informiert und Ticket geschlossen.',
        'ISS (Interception System Schweiz)', 'Low', 'Closed', 'Die Ausleitung des Gesprächs bricht nach dem Aufbau der Konferenzschaltung ab.', 'ÜPF-ISS', '2018-11-02 14:53:17', '2018-11-11 02:00:56', 'KT', 'ZH', 'REMEDY', '2019-02-26 14:02:16.291000', '83005417', '2019-02-26 14:02:16.291000', '83005417', 1);

INSERT INTO feed (id, external_id, title, type, description, category, priority, status, resolution, assigned_group, submit_timestamp, close_timestamp, company, organization, source, eingabe_timestamp, eingabe_user, mutation_timestamp, mutation_user, version)
VALUES (105, 'inc000000151955', 'U ISS Anfrage zu RTI', null, 'Frage ist, ob die Anrufende Nummer eine Teilnehmernummer ist.
empfohlener Link:
https://www.itu.int/oth/T0202.aspx?parent=T0202
Das sollte über eine Rechtshilfe geklärt werden.', 'ISS (Interception System Schweiz)', 'Low', 'Closed', 'Im Nummerierungsplan  (link: https://www.itu.int/oth/T0202.aspx?parent=T0202   bitte Polen wählen und das Worddokument öffnen) findet sich
72 (NDC)	9	9	Non-geographic number	Mobile telephony service
Ich denke es handelt sich um eine Teilnehmerrufnummer (nicht technisch) eines Mobilfunkbetreibers.
Man wird in Polen abklären, wem diese Rufnummer zugeteilt ist (Rechtshilfe).',
        'ÜPF-ISS', '2018-10-31 17:30:03', '2018-11-06 02:01:05', 'EJPD', 'ISC', 'REMEDY', '2019-02-26 14:02:16.296000', '83005417', '2019-02-26 14:02:16.296000', '83005417', 1);

INSERT INTO feed (id, external_id, title, type, description, category, priority, status, resolution, assigned_group, submit_timestamp, close_timestamp, company, organization, source, eingabe_timestamp, eingabe_user, mutation_timestamp, mutation_user, version)
VALUES (106, 'inc000000151922', 'S: ISS: keine Inhalte bei einer Überwachung', null, '1. Incident Informationen erhalten:
    Im Produkt 1000056427477 LIID: 201810032579360
    Sitzungsstartzeit 30.10.2018, 17:36:37 –
    Sitzungsendzeit 30.10.2018, 18:31:22,
    Duration 54:44 sind keine Inhalte vorhanden. Sodann fehlt die
    Switch start time sowie die „Von-An“ Nummern.

   Aus meiner Sicht ergibt der Eintrag keinen Sinn, da kurze Zeit
   nach der Sitzungsstartzeit bereits andere Verbindungen mit
   kurzen Gesprächen verzeichnet sind.

2. Analysieren des Produktes
    Im RAW File zu dem Produkt ist ersichtlich, dass ein Anruf mit
    BYE beendet werden soll. Das System kann den bereits
    beendeten Anruf nicht finden und es entsteht im ISS ein Anruf
    Produkt mit 54 Minuten Dauer. --> Anruf ignorieren.

3. Kunde per Mail über den Anruf ohne Inhalt informiert
    --> Ticket kann geschlossen werden',
        'ISS (Interception System Schweiz)', 'Low', 'Closed', 'Der Anruf mit 54 Minuten und ohne Inhalt ist ein fehlerhaftes Produkt und kann ignoriert werden.', 'ÜPF-ISS', '2018-10-31 09:44:45', '2018-11-06 02:01:05', 'KAPO', 'ZH', 'REMEDY', '2019-02-26 14:02:16.300000', '83005417', '2019-02-26 14:02:16.300000', '83005417', 1);

INSERT INTO feed (id, external_id, title, type, description, category, priority, status, resolution, assigned_group, submit_timestamp, close_timestamp, company, organization, source, eingabe_timestamp, eingabe_user, mutation_timestamp, mutation_user, version)
VALUES (107, 'inc000000151903', 'F Lycamobile: Verdacht auf unvollständige Aktivierung', null, '30.10.2018 15:42 Meldung via Extranet eingetroffen

 30.10.2018 16:34 Erstanruf beim KUnden (Weitere Infos verlangt und erhalten: SMS werden ausgeleitet (inkl. Standort), aber keine Sprache. Eine Observation hat aber den Gebrauch des Telefones gezeigt. Ev. wird eine App (z. Bsp. Skype) verwendet.

31.10.2018 14:35 Anruf bei Swisscom: Es wird bestätigt, dass SMS und Calls gleichzeitig in einem Auftrag aktiviert werden

31.10.2018 17:00 Anruf beim Kunde: Aussage stimmt, in der Zwischenzeit sind Calls ausgeleitet worden. Ticket kann geschlossen werden.',
        'ISS (Interception System Schweiz)', 'Low', 'Closed', 'Es sind Daten eingetroffen. Ticket wird geschlossen.', 'ÜPF-ISS', '2018-10-30 17:09:27', '2018-11-14 02:01:20', 'KAPO', 'TI', 'REMEDY', '2019-02-26 14:02:16.304000', '83005417', '2019-02-26 14:02:16.304000', '83005417', 1);

INSERT INTO feed (id, external_id, title, type, description, category, priority, status, resolution, assigned_group, submit_timestamp, close_timestamp, company, organization, source, eingabe_timestamp, eingabe_user, mutation_timestamp, mutation_user, version)
VALUES (108, 'inc000000151879', 'F ISS Sprünge in den Standorten', null, '30.10.2018
     Ticket über Extranet.
     Die Sprünge treten nicht für Standortausleitungen aufgrund von Gesprächen oder SMS auf.

Erklärung:
Es dürfte sich um sogenannte "combined location updates" handeln. Dabei wechselt das Target im 2G/3G Netz den LAC oder im 4G Netz den TAC. Dabei wird im jeweils anderen Netz der Standort erneuert. Die dabei angegebene ZellId ist die letzte verwendete in demjenigen Nezt; nicht die gerade am besten erreichbare. Man kann sich da nur auf den LAC oder TAC verlassen.

Wenn man Standortangaben im 2G/3G Netz ( haben 4 mal "-", also 228-02-xxxx-yyyy) und im 4G Netz (zur etwa gleichen Zeit) hat, dann sind die die letzten Angaben zu einem Gespräche/einer SMS die, auf die man sich verlassen sollte. Einzelne dazwischen gestreute (auch paarweise) Location- oder Tracking area updates rühren oft von einem Wechel des TAC oder LAC im verwendeten/nicht verwendeten Netz her.

Bitte auch im Wiki ansehen.', 'ISS (Interception System Schweiz)', 'Low', 'Closed', 'Hallo Hans,

Erklärung:
Es dürfte sich um sogenannte "combined location updates" handeln. Dabei wechselt das Target im 2G/3G Netz den LAC oder im 4G Netz den TAC. Dabei wird im jeweils anderen Netz der Standort erneuert. Die dabei angegebene ZellId ist die letzte verwendete in demjenigen Nezt; nicht die gerade am besten erreichbare. Man kann sich da nur auf den LAC oder TAC verlassen.

Wenn man Standortangaben im 2G/3G Netz ( haben 4 mal "-", also 228-02-xxxx-yyyy) und im 4G Netz (zur etwa gleichen Zeit) hat, dann sind die die letzten Angaben zu einem Gespräche/einer SMS die, auf die man sich verlassen sollte. Einzelne dazwischen gestreute (auch paarweise) Location- oder Tracking area updates rühren oft von einem Wechel des TAC oder LAC im verwendeten/nicht verwendeten Netz her.

Bitte auch im Wiki ansehen, da gibt es schöne Bilder vom Niklaus Hutmacher.',
        'ÜPF-ISS', '2018-10-30 15:12:12', '2018-11-05 02:01:14', 'KAPO', 'BE', 'REMEDY', '2019-02-26 14:02:16.307000', '83005417', '2019-02-26 14:02:16.307000', '83005417', 1);

INSERT INTO feed (id, external_id, title, type, description, category, priority, status, resolution, assigned_group, submit_timestamp, close_timestamp, company, organization, source, eingabe_timestamp, eingabe_user, mutation_timestamp, mutation_user, version)
VALUES (109, 'inc000000151854', 'F  Fragen zu HD_29_Tel & HD_28_NA (Swisscom)', null, '30.10.2018 10:57 Anruf bei Kunde: Frage nach den HD-Daten

30.10.2018 11:00 E-Mail vom Kunden: verschlüsselte HD-Daten

30.10.2018 12:55 Anruf bei Kunde: offene Fragen beantwortet',
        'ISS (Interception System Schweiz)', 'Low', 'Closed', 'offene Fragen beantwortet zu Swisscom HDs beantwortet', 'ÜPF-ISS', '2018-10-30 10:28:12', '2018-11-05 02:01:14', 'KT', 'SZ', 'REMEDY', '2019-02-26 14:02:16.313000', '83005417', '2019-02-26 14:02:16.313000', '83005417', 1);

INSERT INTO feed (id, external_id, title, type, description, category, priority, status, resolution, assigned_group, submit_timestamp, close_timestamp, company, organization, source, eingabe_timestamp, eingabe_user, mutation_timestamp, mutation_user, version)
VALUES (110, 'inc000000151837', 'F Swisscom: Lyca - Produits différents de la cible', null, '29.10.2018 15:10 Erste Ananlyse: Ev. falsche Nummer bei Swisscom geschalten...

29.10.2018 16:00 Weitere Ananlyse:  Nummer ist bei Swisscom falsch geschalten.

29.10.2018 16:47 Ticket bei Swisscom erstellt.

29.10.2018 16:50 Anrufversuch beim Kunden: Kollege antwortet: weiteres Vorgehen wird am 3.10.2018 besprochen

30.10.2018 13:08 Antwort von Swisscom: Alles sei OK

30.10.2018 14:05 Anruf bei Swisscom:Anhang im Detail erklärt-> Swisscom will erneut kontrollieren.

30.10.2018 15:13 Antwort von Swisscom: Fehler gefunden und behoben

30.10.2018 16:00 Anruf beim Kunden: über Reparatur informiert: Ticket kann geschlossen werden.',
        'ISS (Interception System Schweiz)', 'Low', 'Closed', 'Swisscom a corrigée cette interception.', 'ÜPF-ISS', '2018-10-29 14:50:27', '2018-11-05 02:01:14', 'KAPO', 'VD', 'REMEDY', '2019-02-26 14:02:16.317000', '83005417', '2019-02-26 14:02:16.317000', '83005417', 1);

INSERT INTO feed (id, external_id, title, type, description, category, priority, status, resolution, assigned_group, submit_timestamp, close_timestamp, company, organization, source, eingabe_timestamp, eingabe_user, mutation_timestamp, mutation_user, version)
VALUES (111, 'inc000000151768', 'F ISS keine Ausleitung für eine bestimmte Schaltung seit 24.10.18 14:09h', null, '26.10.2018 10:15 über Extranet
In obgenannter ÜM fehlen im Typ RT_23_NA_CC_IRI seit dem 24.10.2018, 14:09:01 die Informationen "Bearer-Änderung"

Wir sind dringend auf die Standorte angewiesen.
Der Zugriff zu analysezwecken ist dem Dienst ÜFP erlaubt.

26.10.2018 10:30h: Rückruf beim User
Analyse zeigt kein generelles Problem bei irgendeinem FDA.
Wir analysieren, dass für dieses Target keine Bearer-Änderungen vorhanden sind, obwohl Telefonate und HTTPS Aktivitäten stattfinden.

26.10.2018 11:30h: Swisscom wird gebeten die Schaltung zu überprüfen.

26.10.2018 13:47h: Die Schaltung funktioniert wieder ordnungsgemäss.

26.10.2018 14:07h: User informiert und Inzident geschlossen.',
        'ISS (Interception System Schweiz)', 'Low', 'Closed', 'Die Swisscom wurde um eine Überprüfung der Schaltung gebeten. Seit 26.10.2018 14:07 funktioniert diese wieder.', 'ÜPF-ISS', '2018-10-26 11:17:33', '2018-11-01 02:02:18', 'KAPO', 'BE', 'REMEDY', '2019-02-26 14:02:16.320000', '83005417', '2019-02-26 14:02:16.320000', '83005417', 1);

INSERT INTO feed (id, external_id, title, type, description, category, priority, status, resolution, assigned_group, submit_timestamp, close_timestamp, company, organization, source, eingabe_timestamp, eingabe_user, mutation_timestamp, mutation_user, version)
VALUES (112, 'inc000000151595', 'S ISS Annotation ">>" nicht speicherbar.', null, 'Von Peter Koster (wurde als Duplikat geschlossen, der Fall ">>" am Anfang einer Verschriftung ist aber nicht gelöst).

23.10.2018 Beginnt eine Translation mit den Buchstaben >>, so wird der Text beim Speichern verändert.

23.10.2018 Die Tests des MCC Kit hatten dieses Fehlverhalten bestätigt. Der Inzident wurde an Verint eskaliert.

07.11.2018 JIRA wurde erstellt und wird bei Verint verfolgt.',
        'ISS (Interception System Schweiz)', 'Low', 'Closed', 'JIRA an Verint', 'ÜPF-ISS', '2018-10-23 20:00:26', '2018-11-13 02:02:24', 'EJPD', 'ISC', 'REMEDY', '2019-02-26 14:02:16.324000', '83005417', '2019-02-26 14:02:16.324000', '83005417', 1);

INSERT INTO feed (id, external_id, title, type, description, category, priority, status, resolution, assigned_group, submit_timestamp, close_timestamp, company, organization, source, eingabe_timestamp, eingabe_user, mutation_timestamp, mutation_user, version)
VALUES (113, 'inc000000151590', 'F Swisscom 4G-VoLTE-Zelle wird ohne Koordinaten ausgeleitet', null, '23.10.2018 14:30 Anruf mit Problemstellung
23.10.2018 14:45 Erweiterte Analyse gestartet

23.10.2018 16:30 Resultat der erweiterten Analyse: ist eine brandneue Zelle

23.10.2018 17:31 Ticket bei Swisscom eröffnet: Lieferung der Koordinaten per E-Mail verlangt & Korrektur in der Ausleitung verlangt

24.10.2018 08:31 E-Mail mit weiteren 6 unvollständigen Zellen an Swisscom gesandt

24.10.2018 09:25 1. Antwort von Swisscom erhalten

24.10.2018 16:08   E-Mail an Kunde (mit Infos zur angefragten Zelle)

26.10.2018 16:02 2. Antwort von Swisscom erhalten: restliche 6 Zellen korrigiert. Ticket kann hiermit geschlossen werden.',
        'ISS (Interception System Schweiz)', 'Low', 'Closed', '26.10.2018 16:02 2. Antwort von Swisscom erhalten: restliche 6 Zellen korrigiert. Ticket kann hiermit geschlossen werden.', 'ÜPF-ISS', '2018-10-23 16:03:30', '2018-11-01 02:02:18', 'KAPO', 'ZH', 'REMEDY', '2019-02-26 14:02:16.329000', '83005417', '2019-02-26 14:02:16.329000', '83005417', 1);
