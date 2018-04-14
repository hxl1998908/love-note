import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TodosComponent } from './todos/todos.component';
import {HttpClientModule} from "@angular/common/http";
import {TodoService} from "./todo.service";
import { TodoDetailComponent } from './todo-detail/todo-detail.component';
import { AppRoutingModule } from './app-routing.module';
import { TabsetPortalComponent } from './tabset-portal/tabset-portal.component';
import { TodoAddComponent } from './todo-add/todo-add.component';


@NgModule({
  declarations: [
    AppComponent,
    TodosComponent,
    TodoDetailComponent,
    TabsetPortalComponent,
    TodoAddComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule.forRoot()
  ],
  providers: [
    TodoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
