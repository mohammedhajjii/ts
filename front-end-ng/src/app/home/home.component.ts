import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  doSomeThing(event: Event){
    console.log(`event data: ${(event.target as HTMLInputElement).value}`)
  }
}
