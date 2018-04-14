import { NgModule } from '@angular/core';
import {Routes, RouterModule} from "@angular/router";
import {TodosComponent} from "./todos/todos.component";
import {TodoDetailComponent} from "./todo-detail/todo-detail.component";

const routes: Routes = [
  {path: '', redirectTo: '/todos', pathMatch: 'full'},
  {path: 'todos', component: TodosComponent},
  {path: 'detail/:todoId', component: TodoDetailComponent},
  {path: 'surprise', component: TodosComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
