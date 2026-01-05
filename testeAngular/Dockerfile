# Estágio 1: Build
FROM node:20-alpine AS build
WORKDIR /app

# Instalação de dependências
COPY package*.json ./
RUN npm install

# Copia o código e gera o build
COPY . .
RUN npx ng build --configuration=production --output-path=dist-custom

# Estágio 2: Servidor Nginx (Execução)
FROM nginx:alpine

# 1. Limpa a pasta padrão do Nginx
RUN rm -rf /usr/share/nginx/html/*

# 2. Copia a sua configuração personalizada de rotas
COPY nginx.conf /etc/nginx/conf.d/default.conf

# 3. Copia os arquivos gerados no estágio de build
# Usamos o caminho que confirmamos que existe
COPY --from=build /app/dist-custom/browser /usr/share/nginx/html/

# 4. O AJUSTE ESSENCIAL:
# Como vimos no seu 'ls', o Angular gerou o arquivo como 'index.csr.html'.
# O comando abaixo cria uma cópia chamada 'index.html' para o Nginx funcionar.
RUN if [ -f /usr/share/nginx/html/index.csr.html ]; then \
        cp /usr/share/nginx/html/index.csr.html /usr/share/nginx/html/index.html; \
    fi

# 5. Garante as permissões de leitura
RUN chmod -R 755 /usr/share/nginx/html

EXPOSE 80

# Inicia o servidor
CMD ["nginx", "-g", "daemon off;"]