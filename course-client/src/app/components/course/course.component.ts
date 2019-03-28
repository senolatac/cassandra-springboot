import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../services/course.service";
import {Course} from "../../model/course";
import {Summary} from "../../model/summary";
import {Router, ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  courseId: string;
  currentCourse: Course;
  currentSummary: Summary;

  constructor(
    private courseService: CourseService,
    private router: Router,
    private route: ActivatedRoute) {
      this.currentCourse = JSON.parse(localStorage.getItem('currentCourse'));
    }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if(params.has('id')){
        this.courseId = params.get('id');
        this.courseService.findSummaryByCourseId(this.courseId).subscribe(data => {
                  if(data){
                   this.currentSummary = data;
                 }
                });
        this.hit();
      }
    });
  }

  hit(){
    this.currentSummary = new Summary();
    this.currentSummary.courseId = this.courseId;
    this.courseService.saveSummary(this.currentSummary).subscribe(data=>{
      console.log("hit");
    });
  }

}
