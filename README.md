docker build  -t money-transfer:1.0 .
docker run --name money-transfer-container -p 5500:5500 money-transfer:1.0
