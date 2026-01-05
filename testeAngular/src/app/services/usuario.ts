import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiUrl = 'http://localhost:8080/api/usuarios'; // URL do seu Spring Boot

  constructor(private http: HttpClient) { }

  // Método para enviar o login/cadastro para o Java
  cadastrar(dados: any): Observable<any> {
    return this.http.post(this.apiUrl, dados, { responseType: 'text' });
  }
}