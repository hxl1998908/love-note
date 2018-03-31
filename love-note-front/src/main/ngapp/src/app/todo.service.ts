import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {catchError, tap} from "rxjs/operators";
import {of} from "rxjs/observable/of";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class TodoService {
  private todosUrl = 'todo'

  constructor(
    private http: HttpClient
  ) { }

  getTodos(): Observable<object[]> {
    return this.http.get<object[]>(this.todosUrl)
      .pipe(
        tap(heroes => console.log(`fetched heroes`)),
        catchError(this.handleError('getTodos', []))
    );
  }

  getTodo(id: number): Observable<object> {
    const url = `${this.todosUrl}/${id}`;
    return this.http.get<object>(url).pipe(
      tap(_ => console.log(`fetched hero id=${id}`)),
      catchError(this.handleError<object>(`getHero id=${id}`))
    );
  }

  updateTodo(todo: object): Observable<any> {
    return this.http.put(this.todosUrl, todo, httpOptions).pipe(
      tap(_ => console.log(`updated hero id=${todo}`)),
      catchError(this.handleError<any>('updateHero'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };

  }
}
