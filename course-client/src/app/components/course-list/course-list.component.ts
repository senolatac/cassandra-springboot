import { Component, OnInit, ViewChild } from '@angular/core';
import {CourseService} from "../../services/course.service";
import {Course} from "../../model/course";
import {MatPaginator, MatTableDataSource, MatSort} from '@angular/material';
import {Router, ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {
  courseList: Array<Course>;
  dataSource: MatTableDataSource<Course> = new MatTableDataSource();
  displayedColumns: string[] = ['detail', 'id', 'title', 'author'];
  errorMessage: string;
  infoMessage: string;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(private courseService: CourseService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.findAllCourses();
  }

  ngAfterViewInit(){
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  findAllCourses() {
        this.courseService.findAllCourses().subscribe(data => {
          this.courseList = data;
          this.dataSource.data = data;
        });
  }

saveCourse(){
  var randomNo = 0;
  if(this.courseList){
    randomNo = this.courseList.length;
  }
  var course = new Course();
  course.title = "Course " + randomNo;
  course.author = "Author " + randomNo;
  this.courseService.saveCourse(course).subscribe(data =>{
    this.infoMessage = "Course is created successfully.";
    if(!this.courseList){
      this.courseList = [];
    }
    this.courseList.push(data);
    this.dataSource = new MatTableDataSource(this.courseList);
  }, err=>{
    this.errorMessage = "Unexpected error is occurred.";
  });
}

detail(course: Course){
  localStorage.setItem('currentCourse', JSON.stringify(course));
  this.router.navigate(['/course',course.id]);
}


}
