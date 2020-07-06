# Crud_remake
Come è stato creato il progetto (si considerano già presenti Database, servet Tomcat 9 ed ogni altro programma sulla macchina):
- Creazione su Eclipse di un dynamic web project
- Conversione del DWP in un progetto Maven
- Aggiunta al pom delle dipendenze necessarie (javax servlet, jstl, ojdbc8, junit)
- Creazione di servlet di test, per verificare il funzionamento del server Tc9
- Creazione classe Java dell'entità 'User'
- Creazione classe statica helper per la connessione al DB
- Creazione servlet primaria di smistamento delle richieste (+ test di raggiungimento)
- Creazione index.html con menu di base
- Creazione pagine jsp per l'acquisizione e la visualizzazione dei dati
- Creazione classe statica DBActions, per la scrittura di query sql e l'invio al DB
- Creazione pathing tra pagine jsp e funzione primaria processRequest per lo smistamento
- Creazione switch tra funzione primaria e funzioni specializzate (creazione utente, cancellazione, modifica etc)
