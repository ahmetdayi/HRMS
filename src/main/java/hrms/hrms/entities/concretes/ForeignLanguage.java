package hrms.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "foreignLanguages")
public class ForeignLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foreignLanguageId")
    private int foreignLanguageId;

    @Column(name = "foreignLanguageName", nullable = false)
    private String foreignLanguageName;


    @Column(name = "foreignLanguageLevel", nullable = false)
    private int foreignLanguageLevel;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "cvId")
    private Cv cv;

    public void addForeignLanguageToCv(Cv cv){
        this.cv=cv;
    }
}
