import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {Expense} from '../../models/expense';
import {ExpenseService} from '../../services/expense.service';

@Component({
  selector: 'app-add-expense',
  templateUrl: './add-expense.component.html',
  styleUrls: ['./add-expense.component.css']
})
export class AddExpenseComponent implements OnInit {

  expense: Expense = new Expense();

  constructor(private expenseService: ExpenseService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const isIdPresent = this.activatedRoute.snapshot.paramMap.has('id');
    if (isIdPresent) {
        const id = +this.activatedRoute.snapshot.paramMap.get('id');
        this.expenseService.getExpense(id).subscribe(data => this.expense = data);
    }
  }

  saveExpense() {
    this.expenseService.saveExpense(this.expense).subscribe(
      data => {
        console.log('response', data);
        this.router.navigateByUrl('/expenses');
      }
    );
  }

  deleteExpense(id: number) {
    this.expenseService.deleteExpense(id).subscribe(
      data => {
        console.log('deleted response', data);
        this.router.navigateByUrl('/expenses');
      }
    );
  }

}
