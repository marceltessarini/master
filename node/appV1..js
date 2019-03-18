let express = require('express');
let app = express();

app.set('view engine', 'ejs');

app.get('/', function(req, resp) {
    resp.send('<html><body>Portal de Notícias</body></html>');
});

app.get('/tecnologia', function(req, resp) {
    resp.send('<html><body>Notícias sobre Tecnologia.</body></html>');
});

app.get('/moda', function(req, resp) {
    resp.send('<html><body>Notícias sobre Moda.</body></html>');
});

app.get('/beleza', function(req, resp) {
    resp.send('<html><body>Notícias sobre Beleza.</body></html>');
});


app.listen(3000, function() {
    console.log('Servidor rodando com Express.');
});