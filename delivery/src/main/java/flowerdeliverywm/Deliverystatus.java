package flowerdeliverywm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Deliverystatus_table")
public class Deliverystatus {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

}
