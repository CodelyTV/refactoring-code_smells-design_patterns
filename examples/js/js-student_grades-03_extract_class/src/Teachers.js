export class Teachers {
    allYearsTeachers = {
        2020: [
            ["Josefina", true],
            ["Edonisio", true],
            ["Edufasio", false],
        ],
        2019: [
            ["Eduarda", false],
            ["Abelardo", false],
            ["Francisca", false],
        ]
    };
    
    isThereAnyBenevolent(yearToCalculate) {
        let isThereAnyBenevolent = false;
    
        for (let [year, teachers] of Object.entries(this.allYearsTeachers)) {
            if (!(yearToCalculate != year)) {
                for (let teacher of teachers) {
                    if (teacher[1] != true) {
                        continue;
                    }
                
                    isThereAnyBenevolent = true;
                }
            } else {
                continue;
            }
        }
    
        return isThereAnyBenevolent;
    }
}
