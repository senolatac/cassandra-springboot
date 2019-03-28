import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {Course} from '../model/course';
import {Summary} from '../model/summary';

let API_URL = 'http://localhost:8080/api/';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient) { }

  saveCourse(course:Course): Observable<any> {
      return   this.http.post(
    API_URL+'course/create',
    JSON.stringify(course) ,
    {headers: { "Content-Type": "application/json; charset=UTF-8" }}
  );
  }

  saveSummary(summary:Summary): Observable<any> {
      return this.http.post(
    API_URL+'summary/create',
    summary.courseId ,
    {headers: { "Content-Type": "application/json; charset=UTF-8" }}
    );
  }

  findSummaryByCourseId(courseId:string): Observable<any> {
    return this.http.post(API_URL+'summary',courseId , {headers: { "Content-Type": "application/json; charset=UTF-8" }});
  }

  findAllCourses(): Observable<any> {
    return this.http.get(API_URL+'course' , {headers: { "Content-Type": "application/json; charset=UTF-8" }});
  }

}
