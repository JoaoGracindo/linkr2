FROM node:latest AS angular
WORKDIR /app
COPY package.json /app
RUN npm install
COPY . .
RUN npm run build

FROM nginx
VOLUME /var/cache/nginx
COPY --from=angular /app/dist/front-end /usr/share/nginx/html
COPY ./config/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
 
ENTRYPOINT ["nginx","-g","daemon off;"]