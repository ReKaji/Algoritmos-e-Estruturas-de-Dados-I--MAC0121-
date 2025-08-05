# Exercício:

Arquivos no formato csv (comma separated values) são comuns e muito usados. Neste exercício, estamos interessados no arquivo em

https://www.ime.usp.br/~yoshi/DATA/CSVs/dbip-city-lite-2020-05.IPv4.csv

produzido a partir de um arquivo livremente acessível em https://db-ip.com/db/lite.php. O arquivo dbip-city-lite-2020-05.IPv4.csv acima contém informações sobre a distribuição de números IPs ao redor do mundo. Por exemplo, a linha

200.144.160.0,200.144.255.255,SA,BR,"São Paulo","São Paulo",-23.5614,-46.7308

de dbip-city-lite-2020-05.IPv4.csv indica que números IP entre 200.144.160.0 e 200.144.255.255 estão alocados para a cidade de São Paulo e coordenadas (latitude e longitude) também são fornecidas (experimente buscar "google maps -23.5614, -46.7308" no Google).

Cada linha de dbip-city-lite-2020-05.IPv4.csv é constituído de oito itens, separados por vírgulas. Neste exercício, você implementará um esquema para identificar os oito itens em cada linha daquele arquivo.

Tipo TokenFinder.  Neste exercício, você deve implementar um tipo de dado chamado TokenFinder, com API

public class TokenFinder
----------------------------------------------------------------------
TokenFinder(String line) ... constrói um tokenfinder a partir de line
String nextToken()       ... devolve o próximo item

O programa TFClient.java, fornecido abaixo, ilustra o uso de TokenFinder. Estude TFClient.java e estude também os arquivos 13.txt e 13.out envolvidos na execução

$ java-algs4 TFClient < 13.txt > 13.out

de TFClient.java. As linhas de 13.txt vêm do arquivo dbip-city-lite-2020-05.IPv4.csv. Note que um "token" na linha

169.232.0.0,169.232.255.255,NA,US,California,"Los Angeles (Westwood, Los Angeles)",34.0675,-118.447

de 13.txt está entre aspas. Assim, nextToken() deverá identificar que a vírgula contida naquele token deve ser "ignorada". Considere agora a linha

197.218.0.0,197.218.24.255,AF,MZ,"Maputo City","Maputo (Alto Maé ""B"")",-25.9648,32.5639

Nesta linha, usa-se uma convenção: duas aspas duplas seguidas representam o caractere '"'.

Para escrever TokenFinder.java, inspire-se em Words.java (dado abaixo), discutido em aula no dia 21/11/2023.

Exemplos de execução.  Seguem alguns exemplos de execução de TFClient.java (para conferir saídas).

$ head -n100 DATA/dbip-city-lite-2020-05.IPv4.csv | java-introcs TFClient | md5sum
c632660a5f051a0f435300e59fbc2cfc
$ head -n100000 DATA/dbip-city-lite-2020-05.IPv4.csv | java-introcs TFClient | md5sum
a0d88d8797fd37fdbf4680dfe766474d
$ head -n200000 DATA/dbip-city-lite-2020-05.IPv4.csv | java-introcs TFClient | md5sum
bc494323eee78aa2d2d7b81b68fb6005
$ head -n400000 DATA/dbip-city-lite-2020-05.IPv4.csv | java-introcs TFClient | md5sum
e08bb93e5f1d8a74c08e2a2037352731
$ head -n800000 DATA/dbip-city-lite-2020-05.IPv4.csv | java-introcs TFClient | md5sum
005987ddc9d567a868868a67dd6913a6
$

(No macOS, substitua md5sum por md5.)
