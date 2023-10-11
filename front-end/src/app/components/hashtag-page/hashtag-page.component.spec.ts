import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HashtagPageComponent } from './hashtag-page.component';

describe('HashtagPageComponent', () => {
  let component: HashtagPageComponent;
  let fixture: ComponentFixture<HashtagPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HashtagPageComponent]
    });
    fixture = TestBed.createComponent(HashtagPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
