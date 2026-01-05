import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from '../../services/usuario'; // Importe o serviço
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class LoginComponent {
  loginData = { username: '', password: '' };

  constructor(private usuarioService: UsuarioService, private router: Router) {}

  mensagemSucesso: string = '';

  fazerLogin() {
    this.usuarioService.cadastrar(this.loginData).subscribe({
    next: (resposta) => {
      // 1. O alerta deve ficar aqui dentro!
      alert('Usuário salvo com sucesso!'); 
      
      console.log('Salvo com sucesso!', resposta);
      
      // 2. A navegação acontece depois que o usuário clica no "OK" do alerta
      this.router.navigate(['/home']); 
    },
    error: (erro) => {
      alert('Erro ao conectar com o backend.');
      console.error(erro);
    }
    });
  }
}